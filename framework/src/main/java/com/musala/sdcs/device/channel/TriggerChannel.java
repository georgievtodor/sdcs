package com.musala.sdcs.device.channel;

import java.sql.SQLException;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.TriggerType;

/**
 * This class defines trigger channel
 *
 */
public class TriggerChannel extends AbstractChannel<TriggerType> {

	public TriggerChannel(Integer id, String label, String channelType, TriggerType command) {
		super(id, label, channelType, command);
	}

	@Override
	public void executeCommand(TriggerType command) throws SQLException {
		super.executeCommand(command);
	}
}
