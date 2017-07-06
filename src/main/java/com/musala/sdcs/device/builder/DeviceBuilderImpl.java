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
	private Integer id;
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

	private Integer getId() {
		return id;
	}

	@Override
	public DeviceBuilder withId(Integer id) {
		this.id = id;
		return this;
	}

	@Override
	public DeviceBuilder withManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	private String getManufacturer() {
		return manufacturer;
	}

	@Override
	public DeviceBuilder withModelId(String modelId) {
		this.modelId = modelId;
		return this;
	}

	private String getModelId() {
		return modelId;
	}

	@Override
	public DeviceBuilder withSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	private String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public DeviceBuilder withFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
		return this;
	}

	private String getFirmwareVersion() {
		return firmwareVersion;
	}

	@Override
	public DeviceBuilder withHardwareVersion(int hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
		return this;
	}

	private int getHardwareVersion() {
		return hardwareVersion;
	}

	@Override
	public DeviceBuilder withLabel(String label) {
		this.label = label;
		return this;
	}

	private String getLabel() {
		return label;
	}

	private List<Channel> getChannels() {
		return channels;
	}

	public DeviceBuilder withChannels(List<Channel> channels) {
		this.channels = channels;
		return this;
	}

	@Override
	public Device build() {
		return new DeviceImpl(this.getId(), this.getManufacturer(), this.getModelId(), this.getSerialNumber(),
				this.getFirmwareVersion(), this.getHardwareVersion(), this.getLabel(), this.getChannels());
	}
}