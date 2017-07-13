package com.musala.sdcs.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.repository.DeviceRepository;

/**
 * {@link DeviceController} handles Http requests and gives proper response to each of them.
 *
 */
@RestController
public class DeviceController {
	@Autowired
	DeviceRepository drepo;
	
	
	/**
	 * @return all available devices
	 * 
	 */
	@RequestMapping("/")
	@CrossOrigin
	public List<Device> getDevices() {
		return  drepo.getAllDevices();
	}
	
	/**
	 * @param id
	 * @return device by given id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin
	public Device getDeviceById(@PathVariable("id") int id) {
		return drepo.getDeviceById(id);
	}
	
	/**
	 * @param channelId
	 * @param newCommand
	 * @return updates device channel command
	 */
	@RequestMapping(value = "/channel/{id}", method = RequestMethod.PUT)
	@CrossOrigin
	public boolean updateChannelCommand(@PathVariable("id") int channelId, @PathVariable("command") String newCommand) {
		
		
		return true;
	}
}
