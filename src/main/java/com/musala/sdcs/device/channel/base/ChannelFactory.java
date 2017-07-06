package com.musala.sdcs.device.channel.base;

import com.musala.sdcs.device.channel.DimmingChannel;
import com.musala.sdcs.device.channel.SongControlChannel;
import com.musala.sdcs.device.channel.SongURLChannel;
import com.musala.sdcs.device.channel.TriggerChannel;
import com.musala.sdcs.device.channel.VolumeChannel;
import com.musala.sdcs.device.channel.type.PercentType;
import com.musala.sdcs.device.channel.type.PlayControlType;
import com.musala.sdcs.device.channel.type.TriggerType;
import com.musala.sdcs.device.channel.type.URLType;

public class ChannelFactory {
	public static DimmingChannel createDimmingChannel(Integer id, String label, String command) {
		PercentType commandVal = new PercentType(command);
		return new DimmingChannel(id, label, commandVal);
	}

	public static SongControlChannel createSongControlChannel(Integer id, String label, String command) {
		return new SongControlChannel(id, label, PlayControlType.getCommandValueFromString(command));
	}

	public static SongURLChannel createSongURLChannel(Integer id, String label, String command) {
		URLType commandVal = new URLType(command);
		return new SongURLChannel(id, label, commandVal);
	}

	public static TriggerChannel createTriggerChannel(Integer id, String label, String command) {
		return new TriggerChannel(id, label, TriggerType.getCommandValueFromString(command));
	}

	public static Channel createVolumeChannel(Integer id, String label, String command) {
		PercentType commandVal = new PercentType(command);
		return new VolumeChannel(id, label, commandVal);
	}
}
