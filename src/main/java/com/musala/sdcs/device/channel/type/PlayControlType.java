package com.musala.sdcs.device.channel.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.exception.InvalidCommandTypeException;

/**
 * {@link PlayControlType} describes a concrete command type
 *
 */
public enum PlayControlType {
	Play, Pause, Stop;

	private static final String INVALID_PLAY_CONTROL_TYPE_EXCEPTION_MESSAGE = "PlayControlType must be Play, Pause or Stop, instead got %s";
	private static final String CMD_PLAY_STRING = "Play";
	private static final String CMD_PAUSE_STRING = "Pause";
	private static final String CMD_STOP_STRING = "Stop";

	private static final Logger logger = LoggerFactory.getLogger(PlayControlType.class);

	public static PlayControlType getCommandValueFromString(String type) {
		switch (type) {
		case CMD_PLAY_STRING:
			return Play;
		case CMD_PAUSE_STRING:
			return Pause;
		case CMD_STOP_STRING:
			return Stop;
		default:
			String errorMessage = String.format(INVALID_PLAY_CONTROL_TYPE_EXCEPTION_MESSAGE, type);

			logger.error(errorMessage);
			throw new InvalidCommandTypeException(errorMessage);
		}
	}
}
