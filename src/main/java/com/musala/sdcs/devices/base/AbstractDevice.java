package com.musala.sdcs.devices.base;

public abstract class Device implements IDevice {
    private String manufacturer;
    private String modelId;
    private String serialNumber;
    private String firmwareVersion;
    private int hardwareVersion;
    private String label;

    public Device() {
        
    }
    
    public Device(String manufacturer, String modelId, String serialNumber, String firmwareVersion, int hardwareVersion,
            String label) {
        this.setManufacturer(manufacturer);
        this.setModelId(modelId);
        this.setSerialNumber(serialNumber);
        this.setFirmwareVersion(firmwareVersion);
        this.setHardwareVersion(hardwareVersion);
        this.setLabel(label);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public int getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(int hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
