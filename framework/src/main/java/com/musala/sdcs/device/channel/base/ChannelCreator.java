package com.musala.sdcs.device.channel.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.exception.InvalidChannelTypeException;

/**
 * Creates channel based on channel type given by the DB
 *
 */
public class ChannelCreator {
	private static final String INVALID_CHANNEL_TYPE_MESSAGE = "%s is not a valid type.";
	private static final String LOGGER_ERROR_MESSAGE = "Invalid channel type was passed to the method. Passed channel was: %s";

	private static final String DIMMING_CHANNEL = "DimmingChannel";
	private static final String SONG_CONTROL_CHANNEL = "SongControlChannel";
	private static final String SONG_URL_CHANNEL = "SongURLChannel";
	private static final String TRIGGER_CHANNEL = "TriggerChannel";
	private static final String VOLUME_CHANNEL = "VolumeChannel";
	private static final String COLOR_CHANNEL = "ColorChannel";

	private static Logger logger = LoggerFactory.getLogger(ChannelCreator.class);

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
			return ChannelFactory.createDimmingChannel(id, label, channelType, command);
		case SONG_CONTROL_CHANNEL:
			return ChannelFactory.createSongControlChannel(id, label, channelType, command);
		case SONG_URL_CHANNEL:
			return ChannelFactory.createSongURLChannel(id, label, channelType, command);
		case TRIGGER_CHANNEL:
			return ChannelFactory.createTriggerChannel(id, label, channelType, command);
		case VOLUME_CHANNEL:
			return ChannelFactory.createVolumeChannel(id, label, channelType, command);
		case COLOR_CHANNEL:
			return ChannelFactory.createColorChannel(id, label, channelType, command);
		default:
			logger.error(String.format(LOGGER_ERROR_MESSAGE, channelType));
			throw new InvalidChannelTypeException(String.format(INVALID_CHANNEL_TYPE_MESSAGE, channelType));
		}

	}

}
