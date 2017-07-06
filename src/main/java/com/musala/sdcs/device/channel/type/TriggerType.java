package com.musala.sdcs.device.channel.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.exception.InvalidCommandTypeException;

/**
 * {@link TriggerType} describes a concrete command type
 *
 */
public enum TriggerType {
	On, Off;

	private static final String INVALID_TRIGGER_TYPE_COMMAND_MESSAGE = "Trigger type must be On or Off, instead got %s";
	private static final String CMD_ON_STRING = "On";
	private static final String CMD_OFF_STRING = "Off";

	private static Logger logger = LoggerFactory.getLogger(TriggerType.class);

	public static TriggerType getCommandValueFromString(String type) {
		switch (type) {
		case CMD_ON_STRING:
			return On;
		case CMD_OFF_STRING:
			return Off;
		default:
			String errorMessage = String.format(INVALID_TRIGGER_TYPE_COMMAND_MESSAGE, type);

			logger.error(errorMessage);
			throw new InvalidCommandTypeException(errorMessage);
		}
	}
}
