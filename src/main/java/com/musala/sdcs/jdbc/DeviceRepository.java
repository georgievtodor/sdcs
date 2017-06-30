package com.musala.sdcs.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.builder.DeviceBuilderImpl;
import com.musala.sdcs.device.channel.base.Channel;
import com.musala.sdcs.device.channel.base.ChannelCreator;

/**
 * This class takes care of DB queries related to devices
 *
 */
public class DeviceRepository {
	private static final String QUERY_GET_DEVICES = "SELECT * FROM devices;";
	private static final String QUERY_GET_DEVICES_CHANNELS = "SELECT * FROM devices_channels WHERE deviceId = %s;";
	private static final String QUERY_GET_CHANNELS = "SELECT * FROM channels WHERE id = %s;";
	private static final String QUERY_GET_CHANNEL_TYPE = "SELECT * FROM channel_types WHERE id = %s";
	private static final String QUERY_GET_MODEL = "SELECT * FROM models WHERE id = %s;";
	private static final String QUERY_GET_MANUFACTURER = "SELECT * FROM manufacturers WHERE id = %s;";
	
	private Connection dbConnection;

	public DeviceRepository() {
		this.dbConnection = DbUtil.getConnection();
	}

	public List<Device> getAllDevices() {
		List<Device> devices = new ArrayList<Device>();
		ResultSet r = executeQuery(QUERY_GET_DEVICES);
		
		try {
			while (r.next()) {
				Integer deviceId = r.getInt("id");
				String serialNumber = r.getString("serialNumber");
				String firmwareVersion = r.getString("firmwareVersion");
				Integer hardwareVersion = r.getInt("hardwareVersion");
				String label = r.getString("label");
				Integer modelId = r.getInt("modelId");
	
				List<Channel> channels = getDeviceChannels(deviceId);
				Map<String, String> modelAndManufacturer = getModelAndManufacturer(modelId);
	
				String model = modelAndManufacturer.get("model");
				String manufacturer = modelAndManufacturer.get("manufacturer");
	
				Device device = DeviceBuilderImpl.getInstance().withLabel(label).withId(deviceId).withFirmwareVersion(firmwareVersion)
						.withHardwareVersion(hardwareVersion).withManufacturer(manufacturer).withModelId(model).withSerialNumber(serialNumber)
						.withChannels(channels).build();
				
				devices.add(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devices;
	}

	/**
	 * @param deviceId
	 * @return List of channels
	 */
	private List<Channel> getDeviceChannels(Integer deviceId) {
		List<Channel> channels = new ArrayList<Channel>();
		String query = String.format(QUERY_GET_DEVICES_CHANNELS, deviceId);

		
			ResultSet r = executeQuery(query);

			try {
				while (r.next()) {
					Integer channelId = r.getInt("channelId");

					channels.add(getChannel(channelId));
				}
			} catch (SQLException e) {
				e.printStackTrace();
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

			try {
				if (r.next()) {
					Integer id = r.getInt("id");
					Integer channelTypeId = r.getInt("channelTypeId");
					String label = r.getString("label");
					String command = r.getString("command");
					String channelType = getChannelType(channelTypeId);

					return ChannelCreator.createChannel(id, label, command, channelType);
				}
			} catch (SQLException e) {
				e.printStackTrace();
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
		
		try {

			ResultSet r = executeQuery(query);
			
			if (r.next()) {
				channelType = r.getString("channelType");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		try {
			
			ResultSet r = executeQuery(query);
			
			if (r.next()) {
				String modelName = r.getString("modelName");
				Integer manufacturerId = r.getInt("manufacturerId");

				String manufacturer = getManufacturer(manufacturerId);

				result.put("model", modelName);
				result.put("manufacturer", manufacturer);

			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		try {
			
			ResultSet result = executeQuery(query);

			if (result.next()) {
				manufacturer = result.getString("manufacturerName");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return manufacturer;
	}
	
	/**
	 * @param query
	 * @return result of the performed query
	 */
	private ResultSet executeQuery(String query) {
		ResultSet result = null;
		
		try {
			
			CallableStatement stmt = dbConnection.prepareCall(query);
			
			result = stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
