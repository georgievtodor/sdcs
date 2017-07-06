package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.URLType;

/**
 * This class defines song URL channel
 *
 */
public class SongURLChannel extends AbstractChannel<URLType> {

	public SongURLChannel(Integer id, String label, URLType command) {
		super(id, label, command);
	}

	@Override
	public void executeCommand(URLType command) {
		super.executeCommand(command);
	}
}
