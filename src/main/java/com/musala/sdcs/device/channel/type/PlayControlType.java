package com.musala.sdcs.device.channel.type;

/**
 * {@link PlayControlType} describes a concrete command type
 *
 */
public enum PlayControlType {
    Play,
    Pause,
    Stop;
	
	private static final String CMD_PLAY_STRING = "Play";
	private static final String CMD_PAUSE_STRING = "Pause";
	private static final String CMD_STOP_STRING = "Stop";
	
	public static PlayControlType getCommandValueFromString(String type) {
		switch (type) {
			case CMD_PLAY_STRING:
				return Play;
			case CMD_PAUSE_STRING:
				return Pause;
			case CMD_STOP_STRING:
				return Stop;
		}
		
		return null;
	}
}
