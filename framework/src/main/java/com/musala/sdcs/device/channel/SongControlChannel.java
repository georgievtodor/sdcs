package com.musala.sdcs.device.channel;

import java.sql.SQLException;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.PlayControlType;

/**
 * This class defines song control channel
 *
 */
public class SongControlChannel extends AbstractChannel<PlayControlType> {

	public SongControlChannel(Integer id, String label, String channelType, PlayControlType command) {
		super(id, label, channelType, command);
	}

	@Override
	public void executeCommand(PlayControlType command) throws SQLException {
		super.executeCommand(command);
	}
}
