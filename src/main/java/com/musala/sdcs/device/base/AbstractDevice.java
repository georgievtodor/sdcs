package com.musala.sdcs.device.base;

import java.util.List;

import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * 
 * {@link AbstractDevice} is abstract implementation of {@link Device}.
 * <p>
 * This class implements all mutual properties and methods of the devices.
 *
 */
public abstract class AbstractDevice implements Device {
    private String manufacturer;
    private String modelId;
    private String serialNumber;
    private String firmwareVersion;
    private int hardwareVersion;
    private String label;
    private List<AbstractChannel> channels;

    /**
     * @param manufacturer device manufacturer
     * @param modelId device model id
     * @param serialNumber device serial number
     * @param firmwareVersion device firmware version
     * @param hardwareVersion device hardware version
     * @param label device label
     */
    public AbstractDevice(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label, List<AbstractChannel> channels) {
        this.setManufacturer(manufacturer);
        this.setModelId(modelId);
        this.setSerialNumber(serialNumber);
        this.setFirmwareVersion(firmwareVersion);
        this.setHardwareVersion(hardwareVersion);
        this.setLabel(label);
        this.setChannels(channels);
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModelId() {
        return modelId;
    }

    @Override
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @Override
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public int getHardwareVersion() {
        return hardwareVersion;
    }

    @Override
    public void setHardwareVersion(int hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    public List<AbstractChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<AbstractChannel> channels) {
        this.channels = channels;
    }
    
    public void addChannel(AbstractChannel channel) {
        this.channels.add(channel);
    }
}
