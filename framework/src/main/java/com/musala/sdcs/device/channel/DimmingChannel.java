package com.musala.sdcs.device.channel;

import java.sql.SQLException;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.NumberType;

/**
 * This class defines dimming channel
 *
 */
public class DimmingChannel extends AbstractChannel<NumberType> {

	public DimmingChannel(Integer id, String label, String channelType, NumberType command) {
		super(id, label, channelType, command);
	}

	@Override
	public void executeCommand(NumberType command) throws SQLException {
		super.executeCommand(command);
	}
}
