package com.musala.sdcs.device.channel.type;

/**
 * {@link TriggerType} describes a concrete command type
 *
 */
public enum TriggerType {
    On,
    Off;
	
	private static final String CMD_ON_STRING = "On";
	private static final String CMD_OFF_STRING = "Off";
	
	public static TriggerType getCommandValueFromString(String type) {
		switch (type) {
			case CMD_ON_STRING:
				return On;
			case CMD_OFF_STRING:
				return Off;
		}
		return null;
	}
}
