package com.musala.sdcs.device.builder;

import java.util.List;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.channel.base.Channel;

/**
 * Representation of the builder properties and methods
 *
 */
public interface DeviceBuilder {
	
	/**
	 * sets the device id
	 * @param id
	 * @return current class instance for chaining
	 */
	DeviceBuilder withId(Integer id);
	
	/**
     * sets device manufacturer
     * 
     * @param manufacturer
     * @return current class instance for chaining
     */
    DeviceBuilder withManufacturer(String manufacturer);

    /**
     * sets device model id
     * 
     * @param modelId
     * @return current class instance for chaining
     */
    DeviceBuilder withModelId(String modelId);

    /**
     * sets device serial number
     * 
     * @param serialNumber
     * @return current class instance for chaining
     */
    DeviceBuilder withSerialNumber(String serialNumber);

    /**
     * sets device firmware version
     * 
     * @param firmwareVersion
     * @return current class instance for chaining
     */
    DeviceBuilder withFirmwareVersion(String firmwareVersion);

    /**
     * sets device hardware version
     * 
     * @param hardwareVersion
     * @return current class instance for chaining
     */
    DeviceBuilder withHardwareVersion(int hardwareVersion);

    /**
     * sets device label
     * 
     * @param label
     * @return current class instance for chaining
     */
    DeviceBuilder withLabel(String label);

    /**
     * sets device channels
     * 
     * @param channels
     * @return current class instance for chaining
     */
    DeviceBuilder withChannels(List<Channel> channels);

    /**
     * @return new device with set'ed properties
     */
    Device build();
}