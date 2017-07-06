package com.musala.sdcs.device.channel.type;

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

	public static TriggerType getCommandValueFromString(String type) {
		switch (type) {
		case CMD_ON_STRING:
			return On;
		case CMD_OFF_STRING:
			return Off;
		default:
			throw new InvalidCommandTypeException(String.format(INVALID_TRIGGER_TYPE_COMMAND_MESSAGE, type));
		}
	}
}
