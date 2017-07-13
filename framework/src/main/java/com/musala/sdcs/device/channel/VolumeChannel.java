package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.PercentType;

/**
 * This class defines volume channel
 *
 */
public class VolumeChannel extends AbstractChannel<PercentType> {

	public VolumeChannel(Integer id, String label, String channelType, PercentType command) {
		super(id, label, channelType, command);
	}

	@Override
	public void executeCommand(PercentType command) {
		super.executeCommand(command);
	}
}
