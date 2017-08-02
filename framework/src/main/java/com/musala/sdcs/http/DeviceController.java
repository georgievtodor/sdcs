package com.musala.sdcs.http;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.repository.ChannelRepository;
import com.musala.sdcs.repository.DeviceRepository;

/**
 * {@link DeviceController} handles Http requests and gives proper response to
 * each of them.
 *
 */
@RestController
public class DeviceController {
	private static final String LOGGER_INVALID_SQL_MESSAGE = "Invalid sql query given";
	private static final String SIMULATOR_URL = "http://localhost:3002/";
	private static final String ANGULAR_URL = "http://localhost:4200/";

	private Logger logger = LoggerFactory.getLogger(DeviceController.class);
	private Requester requester = new Requester();

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	ChannelRepository channelRepository;

	/**
	 * @return all available devices
	 * 
	 */
	@RequestMapping("/")
	@CrossOrigin
	public List<Device> getDevices() {
		return deviceRepository.getAllDevices();
	}

	/**
	 * @param id
	 * @return device by given id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin
	public Device getDeviceById(@PathVariable("id") int id) {
		return deviceRepository.getDeviceById(id);
	}

	/**
	 * @param deviceId
	 * @param body
	 * @return updates device
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@CrossOrigin
	@ResponseBody
	public String updateDevice(@PathVariable("id") Integer deviceId, @RequestBody Map<String, Object> body) {
		String label = body.get("label").toString();
		String firmwareVersion = body.get("firmwareVersion").toString();
		String hardwareVersion = body.get("hardwareVersion").toString();

		try {
			String result = deviceRepository.updateDevice(label, firmwareVersion, hardwareVersion, deviceId);

			Map<String, String> json = new HashMap<String, String>();
			json.put("id", deviceId.toString());
			json.put("label", label);
			json.put("type", "update device");
			json.put("firmwareVersion", firmwareVersion);
			json.put("hardwareVersion", hardwareVersion);
			JSONObject jsonResult = new JSONObject(json);

			sendNotification(jsonResult, SIMULATOR_URL);

			return result;
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
			return "failed";
		}
	}

	/**
	 * @param channelId
	 * @param body
	 * @return updates device channel label
	 */
	@RequestMapping(value = "/channel/label/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@CrossOrigin
	@ResponseBody
	public String updateChannelLabel(@PathVariable("id") Integer channelId, @RequestBody Map<String, Object> body) {
		String label = body.get("label").toString();
		String channelType = body.get("channelType").toString();

		try {
			String result = channelRepository.updateChannelLabel(label, channelId, channelType);

			Map<String, String> json = new HashMap<String, String>();
			json.put("id", channelId.toString());
			json.put("label", label);
			json.put("type", "update channel label");
			json.put("channelType", channelType);
			JSONObject jsonResult = new JSONObject(json);

			sendNotification(jsonResult, SIMULATOR_URL);

			return result;
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
			return "failed";
		}
	}

	/**
	 * @param channelId
	 * @param body
	 * @return updates device channel command
	 */
	@RequestMapping(value = "/channel/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@CrossOrigin
	@ResponseBody
	public String updateChannelCommand(@PathVariable("id") Integer channelId, @RequestBody Map<String, Object> body) {
		String command = body.get("command").toString();
		String channelType = body.get("channelType").toString();

		try {
			String result = channelRepository.updateChannelCommand(command, channelId, channelType);

			Map<String, String> json = new HashMap<String, String>();
			json.put("id", channelId.toString());
			json.put("command", command);
			json.put("type", "update channel");
			json.put("channelType", channelType);
			JSONObject jsonResult = new JSONObject(json);

			sendNotification(jsonResult, SIMULATOR_URL);

			return result;
		} catch (SQLException e) {
			logger.error(LOGGER_INVALID_SQL_MESSAGE, e);
			return "failed";
		}
	}
	
	@RequestMapping(value = "/channel/{id}", method = RequestMethod.GET)
	@CrossOrigin
	public String checkIfChannelValueIsUpdated(@PathVariable("id") Integer channelId) {
		return channelRepository.getChannelCommandValue(channelId);
	}

	private void sendNotification(JSONObject jsonResult, String url) {
		requester.makePostRestJSONCall(url, jsonResult.toJSONString());
	}

}
