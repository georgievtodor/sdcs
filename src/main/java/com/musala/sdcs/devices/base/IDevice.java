package com.musala.sdcs.devices.base;

public interface IDevice {

    String getManufacturer();

    void setManufacturer(String manufacturer);

    String getModelId();

    void setModelId(String modelId);

    String getSerialNumber();

    void setSerialNumber(String serialNumber);

    String getFirmwareVersion();

    void setFirmwareVersion(String firmwareVersion);

    int getHardwareVersion();

    void setHardwareVersion(int hardwareVersion);

    String getLabel();

    void setLabel(String label);

}