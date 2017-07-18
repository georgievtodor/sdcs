package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.ColorType;

public class ColorChannel extends AbstractChannel<ColorType> {
	
	public ColorChannel(Integer id, String label, String channelType, ColorType command) {
		super(id, label, channelType, command);
	}

	@Override
	public void executeCommand(ColorType command) {
		super.executeCommand(command);
	}

}
