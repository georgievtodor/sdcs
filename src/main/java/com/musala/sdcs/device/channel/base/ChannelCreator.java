package com.musala.sdcs.device.channel.base;

import com.musala.sdcs.device.channel.DimmingChannel;
import com.musala.sdcs.device.channel.SongControlChannel;
import com.musala.sdcs.device.channel.SongURLChannel;
import com.musala.sdcs.device.channel.TriggerChannel;
import com.musala.sdcs.device.channel.VolumeChannel;
import com.musala.sdcs.device.channel.type.PlayControlType;
import com.musala.sdcs.device.channel.type.TriggerType;
import com.musala.sdcs.exception.InvalidChannelTypeException;

/**
 * Creates channel based on channel type given by the DB
 *
 */
public class ChannelCreator {

	private static final String INVALID_CHANNEL_TYPE_MESSAGE = "%s is not a valid type.";

	private static final String DIMMING_CHANNEL = "DimmingChannel";
	private static final String SONG_CONTROL_CHANNEL = "SongControlChannel";
	private static final String SONG_URL_CHANNEL = "SongURLChannel";
	private static final String TRIGGER_CHANNEL = "TriggerChannel";
	private static final String VOLUME_CHANNEL = "VolumeChannel";

	/**
	 * @param id
	 *            channel id
	 * @param label
	 *            channel label
	 * @param command
	 *            current command
	 * @param channelType
	 *            channel type
	 * @return correct channel type
	 */
	public static Channel createChannel(Integer id, String label, String command, String channelType) {
		switch (channelType) {
		case DIMMING_CHANNEL:
			return ChannelFactory.createDimmingChannel(id, label, command);
		case SONG_CONTROL_CHANNEL:
			return ChannelFactory.createSongControlChannel(id, label, command);
		case SONG_URL_CHANNEL:
			return ChannelFactory.createSongURLChannel(id, label, command);
		case TRIGGER_CHANNEL:
			return ChannelFactory.createTriggerChannel(id, label, command);
		case VOLUME_CHANNEL:
			return ChannelFactory.createVolumeChannel(id, label, command);
		default:
			throw new InvalidChannelTypeException(String.format(INVALID_CHANNEL_TYPE_MESSAGE, channelType));
		}

	}

}
