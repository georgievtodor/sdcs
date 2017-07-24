package com.musala.sdcs.http;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.TextNode;
import com.musala.sdcs.device.Device;
import com.musala.sdcs.repository.ChannelRepository;
import com.musala.sdcs.repository.DeviceRepository;

/**
 * {@link DeviceController} handles Http requests and gives proper response to each of them.
 *
 */
@RestController
public class DeviceController {
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
		return  deviceRepository.getAllDevices();
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
	public String updateDevice(@PathVariable("id") int deviceId, @RequestBody Map<String, Object> body) {
		String label = body.get("label").toString();
		String firmwareVersion = body.get("firmwareVersion").toString();
		String hardwareVersion = body.get("hardwareVersion").toString();
		
		return deviceRepository.updateDevice(label, firmwareVersion, hardwareVersion, deviceId);
	}
	
	
	/**
	 * @param channelId
	 * @param body
	 * @return updates device channel label
	 */
	@RequestMapping(value = "/channel/label/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@CrossOrigin
	@ResponseBody
	public String updateChannelLabel(@PathVariable("id") int channelId, @RequestBody Map<String, Object> body) {
		String label = body.get("label").toString();
		
		return channelRepository.updateChannelLabel(label, channelId);
	}
	
	/**
	 * @param channelId
	 * @param body
	 * @return updates device channel command
	 */
	@RequestMapping(value = "/channel/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@CrossOrigin
	@ResponseBody
	public String updateChannelCommand(@PathVariable("id") int channelId, @RequestBody Map<String, Object> body) {
		String command = body.get("command").toString();
		
		return channelRepository.updateChannelCommand(command, channelId);
	}
	
	
}
