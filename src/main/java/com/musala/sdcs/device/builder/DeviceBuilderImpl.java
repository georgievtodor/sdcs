package com.musala.sdcs.device.builder;

import java.util.List;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.DeviceImpl;
import com.musala.sdcs.device.channel.base.Channel;

/**
 * Implementation of {@link DeviceBuilder}
 *
 */
public class DeviceBuilderImpl implements DeviceBuilder {
    private String manufacturer;
    private String modelId;
    private String serialNumber;
    private String firmwareVersion;
    private int hardwareVersion;
    private String label;
    private List<Channel> channels;

    public static DeviceBuilder getInstance() {
        return new DeviceBuilderImpl();
    }
    
    @Override
    public DeviceBuilder withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public DeviceBuilder withModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    @Override
    public String getModelId() {
        return modelId;
    }

    @Override
    public DeviceBuilder withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public DeviceBuilder withFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return this;
    }

    @Override
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @Override
    public DeviceBuilder withHardwareVersion(int hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
        return this;
    }

    @Override
    public int getHardwareVersion() {
        return hardwareVersion;
    }

    @Override
    public DeviceBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public DeviceBuilder withChannels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }

    @Override
    public Device build() {
        return new DeviceImpl(this.getManufacturer(), this.getModelId(), this.getSerialNumber(), this.getFirmwareVersion(),
                this.getHardwareVersion(), this.getLabel(), this.getChannels());
    }
}