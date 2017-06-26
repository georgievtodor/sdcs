package com.musala.sdcs.devices.builder.base;

/**
 * Abstract implementation of {@link DeviceBuilder}
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class AbstractDeviceBuilder<T> implements DeviceBuilder<T> {
    private String manufacturer;
    private String modelId;
    private String serialNumber;
    private String firmwareVersion;
    private int hardwareVersion;
    private String label;

    @Override
    public T withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return (T) this;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public T withModelId(String modelId) {
        this.modelId = modelId;
        return (T) this;
    }

    @Override
    public String getModelId() {
        return modelId;
    }

    @Override
    public T withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return (T) this;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public T withFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return (T) this;
    }

    @Override
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @Override
    public T withHardwareVersion(int hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
        return (T) this;
    }

    @Override
    public int getHardwareVersion() {
        return hardwareVersion;
    }

    @Override
    public T withLabel(String label) {
        this.label = label;
        return (T) this;
    }

    @Override
    public String getLabel() {
        return label;
    }
}