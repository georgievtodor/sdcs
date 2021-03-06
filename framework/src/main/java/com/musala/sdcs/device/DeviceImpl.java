package com.musala.sdcs.device;

import java.util.ArrayList;
import java.util.List;

import com.musala.sdcs.device.channel.base.Channel;

/**
 * 
 * {@link DeviceImpl} is implementation of {@link Device}.
 * <p>
 * This class implements all mutual properties and methods of the devices.
 *
 */
public class DeviceImpl implements Device {
	private Integer id;
	private String manufacturer;
	private String modelId;
	private String serialNumber;
	private String firmwareVersion;
	private int hardwareVersion;
	private String label;
	private List<Channel> channels;

	/**
	 * @param manufacturer
	 *            device manufacturer
	 * @param modelId
	 *            device model id
	 * @param serialNumber
	 *            device serial number
	 * @param firmwareVersion
	 *            device firmware version
	 * @param hardwareVersion
	 *            device hardware version
	 * @param label
	 *            device label
	 */
	public DeviceImpl(Integer id, String manufacturer, String modelId, String serialNumber, String firmwareVersion,
			int hardwareVersion, String label, List<Channel> channels) {
		setId(id);
		setManufacturer(manufacturer);
		setModelId(modelId);
		setSerialNumber(serialNumber);
		setFirmwareVersion(firmwareVersion);
		setHardwareVersion(hardwareVersion);
		setLabel(label);
		setChannels(channels);
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public List<Channel> getChannels() {
		return channels;
	}

	@Override
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public void addChannel(Channel channel) {
		if (this.channels == null) {
			this.channels = new ArrayList<Channel>();
		}

		this.channels.add(channel);
	}
}
