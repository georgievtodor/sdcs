package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.PercentType;

/**
 * This class defines dimming channel
 *
 */
public class DimmingChannel extends AbstractChannel<PercentType> {

	public DimmingChannel(Integer id, String label, PercentType command) {
		super(id, label, command);
	}

	@Override
	public void executeCommand(PercentType command) {
		super.executeCommand(command);
	}

}
