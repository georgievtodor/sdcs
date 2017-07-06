package com.musala.sdcs.device;

import java.util.List;

import com.musala.sdcs.device.channel.base.Channel;

/**
 * {@link Device} is a representation of the mutual properties across all
 * devices
 *
 */
public interface Device {
	/**
	 * @return the device id
	 */
	Integer getId();

	/**
	 * sets the device id
	 * 
	 * @param id
	 */
	void setId(Integer id);

	/**
	 * @return the manufacturer of the device
	 */
	String getManufacturer();

	/**
	 * sets the device manufacturer
	 * 
	 * @param manufacturer
	 */
	void setManufacturer(String manufacturer);

	/**
	 * @return the model id of the device
	 */
	String getModelId();

	/**
	 * sets the device model id
	 * 
	 * @param modelId
	 */
	void setModelId(String modelId);

	/**
	 * @return the serial number of the device
	 */
	String getSerialNumber();

	/**
	 * sets the device serial number
	 * 
	 * @param serialNumber
	 */
	void setSerialNumber(String serialNumber);

	/**
	 * @return the firmware version of the device
	 */
	String getFirmwareVersion();

	/**
	 * sets the device firmware version
	 * 
	 * @param firmwareVersion
	 */
	void setFirmwareVersion(String firmwareVersion);

	/**
	 * @return the hardware version of the device
	 */
	int getHardwareVersion();

	/**
	 * sets the device hardware version
	 * 
	 * @param hardwareVersion
	 */
	void setHardwareVersion(int hardwareVersion);

	/**
	 * @return the label of the device
	 */
	String getLabel();

	/**
	 * sets the device label
	 * 
	 * @param label
	 */
	void setLabel(String label);

	/**
	 * @return the channels of the device
	 */
	List<Channel> getChannels();

	/**
	 * sets the device channels
	 * 
	 * @param channels
	 */
	void setChannels(List<Channel> channels);

}