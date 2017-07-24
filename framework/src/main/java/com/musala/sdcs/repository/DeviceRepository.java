package com.musala.sdcs.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.musala.sdcs.db.DbUtil;
import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.builder.DeviceBuilderImpl;
import com.musala.sdcs.device.channel.base.Channel;
import com.musala.sdcs.device.channel.base.ChannelCreator;

/**
 * This class takes care of DB queries related to devices
 *
 */
@Repository
public class DeviceRepository {
	private static final String LOGGER_DEVICE_CREATED = "Device created";
	private static final String LOGGER_GETTING_ALL_DEVICES = "Getting all devices";
	private static final String ID = "id";
	private static final String SERIAL_NUMBER = "serialNumber";
	private static final String CHANNEL_TYPE = "channelType";
	private static final String FIRMWARE_VERSION = "firmwareVersion";
	private static final String HARDWARE_VERSION = "hardwareVersion";
	private static final String LABEL = "label";
	private static final String MODEL_ID = "modelId";
	private static final String MAM_MODEL = "model";
	private static final String MAM_MANUFACTURER = "manufacturer";
	private static final String MODEL_NAME = "modelName";
	private static final String MANUFACTURER_ID = "manufacturerId";
	private static final String MANUFACTURER_NAME = "manufacturerName";
	private static final String CHANNEL_ID = "channelId";
	private static final String CHANNEL_TYPE_ID = "channelTypeId";
	private static final String CHANNEL_COMMAND = "command";

	private static final String QUERY_GET_DEVICES = "SELECT * FROM devices;";
	private static final String QUERY_GET_DEVICE_BY_ID = "SELECT * FROM devices WHERE id = %s;";
	private static final String QUERY_GET_DEVICES_CHANNELS = "SELECT * FROM devices_channels WHERE deviceId = %s;";
	private static final String QUERY_GET_CHANNELS = "SELECT * FROM channels WHERE id = %s;";
	private static final String QUERY_GET_CHANNEL_TYPE = "SELECT * FROM channel_types WHERE id = %s";
	private static final String QUERY_GET_MODEL = "SELECT * FROM models WHERE id = %s;";
	private static final String QUERY_GET_MANUFACTURER = "SELECT * FROM manufacturers WHERE id = %s;";
	private static final String QUERY_UPDATE_DEVICE = "UPDATE devices SET label = '%s', firmwareVersion = '%s', hardwareVersion = '%s' WHERE id = %s;";

	private static final String LOGGER_INVALID_SQL_MESSAGE = "Invalid sql query given";

	private Connection dbConnection;
	private Logger logger;

	public DeviceRepository() {
		this.dbConnection = DbUtil.getConnection();
		this.logger = LoggerFactory.getLogger(DeviceRepository.class);
	}

	public List<Device> getAllDevices() {
		List<Device> devices = new ArrayList<Device>();
		
		ResultSet r = executeQuery(QUERY_GET_DEVICES);

		logger.info(LOGGER_GETTING_ALL_DEVICES);
		
		try {
			while (r.next()) {
				devices.add(getDevice(r));
			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}
		return devices;
	}

	public Device getDeviceById(int id) {
		
		String query = String.format(QUERY_GET_DEVICE_BY_ID, id);
		ResultSet r = executeQuery(query);
		
		logger.info(query);
		
		try {
			if (r.next()) {
				return getDevice(r);
			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}
		
		return null;
		
	}

	private Device getDevice(ResultSet r) {
		try {
			Integer deviceId = r.getInt(ID);
			String serialNumber = r.getString(SERIAL_NUMBER);
			String firmwareVersion = r.getString(FIRMWARE_VERSION);
			Integer hardwareVersion = r.getInt(HARDWARE_VERSION);
			String label = r.getString(LABEL);
			Integer modelId = r.getInt(MODEL_ID);
			List<Channel> channels = getDeviceChannels(deviceId);
			Map<String, String> modelAndManufacturer = getModelAndManufacturer(modelId);

			String model = modelAndManufacturer.get(MAM_MODEL);
			String manufacturer = modelAndManufacturer.get(MAM_MANUFACTURER);

			Device device = DeviceBuilderImpl.getInstance().withLabel(label).withId(deviceId)
					.withFirmwareVersion(firmwareVersion).withHardwareVersion(hardwareVersion)
					.withManufacturer(manufacturer).withModelId(model).withSerialNumber(serialNumber)
					.withChannels(channels).build();
			
			logger.info(LOGGER_DEVICE_CREATED);
			
			return device;

		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return null;
	}

	/**
	 * @param deviceId
	 * @return List of channels
	 */
	private List<Channel> getDeviceChannels(Integer deviceId) {
		List<Channel> channels = new ArrayList<Channel>();
		String query = String.format(QUERY_GET_DEVICES_CHANNELS, deviceId);

		ResultSet r = executeQuery(query);
		
		logger.info(query);

		try {
			while (r.next()) {
				Integer channelId = r.getInt(CHANNEL_ID);

				channels.add(getChannel(channelId));
			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return channels;
	}

	/**
	 * @param channelId
	 * @return Channel
	 */
	private Channel getChannel(Integer channelId) {
		String query = String.format(QUERY_GET_CHANNELS, channelId);

		ResultSet r = executeQuery(query);
		
		logger.info(query);

		try {
			if (r.next()) {
				Integer id = r.getInt(ID);
				Integer channelTypeId = r.getInt(CHANNEL_TYPE_ID);
				String label = r.getString(LABEL);
				String command = r.getString(CHANNEL_COMMAND);
				String channelType = getChannelType(channelTypeId);

				return ChannelCreator.createChannel(id, label, command, channelType);
			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}
		return null;

	}

	/**
	 * @param channelTypeId
	 * @return Channel type
	 */
	private String getChannelType(Integer channelTypeId) {
		String query = String.format(QUERY_GET_CHANNEL_TYPE, channelTypeId);
		String channelType = "";
		
		logger.info(query);

		try {

			ResultSet r = executeQuery(query);

			if (r.next()) {
				channelType = r.getString(CHANNEL_TYPE);
			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return channelType;
	}

	/**
	 * @param modelId
	 * @return model and manufacturer
	 */
	private Map<String, String> getModelAndManufacturer(Integer modelId) {
		String query = String.format(QUERY_GET_MODEL, modelId);
		HashMap<String, String> result = new HashMap<String, String>();

		logger.info(query);
		
		try {

			ResultSet r = executeQuery(query);

			if (r.next()) {
				String modelName = r.getString(MODEL_NAME);
				Integer manufacturerId = r.getInt(MANUFACTURER_ID);

				String manufacturer = getManufacturer(manufacturerId);

				result.put(MAM_MODEL, modelName);
				result.put(MAM_MANUFACTURER, manufacturer);

			}
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return result;
	}

	/**
	 * @param manufacturerId
	 * @return manufacturer
	 */
	private String getManufacturer(Integer manufacturerId) {
		String query = String.format(QUERY_GET_MANUFACTURER, manufacturerId);
		String manufacturer = "";

		logger.info(query);
		
		try {

			ResultSet result = executeQuery(query);

			if (result.next()) {
				manufacturer = result.getString(MANUFACTURER_NAME);
			}

		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}

		return manufacturer;
	}
	
	/**
	 * updates device properties
	 * 
	 * @param label
	 * @param firmwareVersion
	 * @param hardwareVersion
	 * @param id
	 * @return success or fail message for front-end handling
	 */
	public String updateDevice(String label, String firmwareVersion, String hardwareVersion, Integer id) {
		String query = String.format(QUERY_UPDATE_DEVICE, label, firmwareVersion, hardwareVersion, id);
		
		logger.info(query);
		
		try {
			CallableStatement stmt = dbConnection.prepareCall(query);
			stmt.executeUpdate();
			
			return "success";

		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
			
			return "failed";
		}
	}

	/**
	 * @param query
	 * @return result of the performed query
	 */
	private ResultSet executeQuery(String query) {
		ResultSet result = null;
		
		logger.info(query);

		try {

			CallableStatement stmt = dbConnection.prepareCall(query);

			result = stmt.executeQuery();

		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
		}
		
		return result;
	}
	
	
}
