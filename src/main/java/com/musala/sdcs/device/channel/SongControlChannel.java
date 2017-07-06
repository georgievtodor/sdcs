package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.PlayControlType;

/**
 * This class defines song control channel
 *
 */
public class SongControlChannel extends AbstractChannel<PlayControlType> {

	public SongControlChannel(Integer id, String label, PlayControlType command) {
		super(id, label, command);
	}

	@Override
	public void executeCommand(PlayControlType command) {
		super.executeCommand(command);
	}
}
