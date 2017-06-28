package com.musala.sdcs.device.builder.base;

import java.util.List;

import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * Generic representation of the builder properties and methods
 *
 * @param <T> type of the builder
 */
public interface DeviceBuilder<T> {

    /**
     * sets device manufacturer
     * 
     * @param manufacturer
     * @return current class instance for chaining
     */
    T withManufacturer(String manufacturer);

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
    T withModelId(String modelId);

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
    T withSerialNumber(String serialNumber);

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
    T withFirmwareVersion(String firmwareVersion);

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
    T withHardwareVersion(int hardwareVersion);

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
    T withLabel(String label);

    /**
     * @return the label of the device
     */
    String getLabel();
    
    T withChannels(List<AbstractChannel> channels);
    
    List<AbstractChannel> getChannels();

}