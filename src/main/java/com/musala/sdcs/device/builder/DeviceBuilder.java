package com.musala.sdcs.device.builder;

import java.util.List;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.channel.base.Channel;

/**
 * Generic representation of the builder properties and methods
 *
 */
public interface DeviceBuilder {
    /**
     * sets device manufacturer
     * 
     * @param manufacturer
     * @return current class instance for chaining
     */
    DeviceBuilder withManufacturer(String manufacturer);

    /**
     * @return the manufacturer of the device
     */
    String getManufacturer();

    /**
     * sets device model id
     * 
     * @param modelId
     * @return current class instance for chaining
     */
    DeviceBuilder withModelId(String modelId);

    /**
     * @return the model id of the device
     */
    String getModelId();

    /**
     * sets device serial number
     * 
     * @param serialNumber
     * @return current class instance for chaining
     */
    DeviceBuilder withSerialNumber(String serialNumber);

    /**
     * @return the serial number of the device
     */
    String getSerialNumber();

    /**
     * sets device firmware version
     * 
     * @param firmwareVersion
     * @return current class instance for chaining
     */
    DeviceBuilder withFirmwareVersion(String firmwareVersion);

    /**
     * @return the firmware version of the device
     */
    String getFirmwareVersion();

    /**
     * sets device hardware version
     * 
     * @param hardwareVersion
     * @return current class instance for chaining
     */
    DeviceBuilder withHardwareVersion(int hardwareVersion);

    /**
     * @return the hardware version of the device
     */
    int getHardwareVersion();

    /**
     * sets device label
     * 
     * @param label
     * @return current class instance for chaining
     */
    DeviceBuilder withLabel(String label);

    /**
     * @return the label of the device
     */
    String getLabel();
    
    /**
     * sets device channels
     * 
     * @param channels
     * @return current class instance for chaining
     */
    DeviceBuilder withChannels(List<Channel> channels);
    
    /**
     * @return all channels of the device
     */
    List<Channel> getChannels();

    /**
     * @return new device with set'ed properties
     */
    Device build();
}