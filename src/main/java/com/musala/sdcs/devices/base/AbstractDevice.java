package com.musala.sdcs.devices.base;

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

    
    /**
     * @param manufacturer device manufacturer
     * @param modelId device model id
     * @param serialNumber device serial number
     * @param firmwareVersion device firmware version
     * @param hardwareVersion device hardware version
     * @param label device label
     */
    public AbstractDevice(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label) {
        this.setManufacturer(manufacturer);
        this.setModelId(modelId);
        this.setSerialNumber(serialNumber);
        this.setFirmwareVersion(firmwareVersion);
        this.setHardwareVersion(hardwareVersion);
        this.setLabel(label);
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
}
