package com.musala.sdcs.device.channel.base;

import com.musala.sdcs.device.channel.ColorChannel;
import com.musala.sdcs.device.channel.DimmingChannel;
import com.musala.sdcs.device.channel.HumidityChannel;
import com.musala.sdcs.device.channel.SongControlChannel;
import com.musala.sdcs.device.channel.SongURLChannel;
import com.musala.sdcs.device.channel.TemperatureChannel;
import com.musala.sdcs.device.channel.TriggerChannel;
import com.musala.sdcs.device.channel.VolumeChannel;
import com.musala.sdcs.device.channel.type.ColorType;
import com.musala.sdcs.device.channel.type.NumberType;
import com.musala.sdcs.device.channel.type.PlayControlType;
import com.musala.sdcs.device.channel.type.TriggerType;
import com.musala.sdcs.device.channel.type.URLType;

public class ChannelFactory {
	public static DimmingChannel createDimmingChannel(Integer id, String label, String channelType, String command) {
		NumberType commandVal = new NumberType(command, 0, 100);
		return new DimmingChannel(id, label, channelType, commandVal);
	}

	public static SongControlChannel createSongControlChannel(Integer id, String label, String channelType, String command) {
		return new SongControlChannel(id, label, channelType, PlayControlType.getCommandValueFromString(command));
	}

	public static SongURLChannel createSongURLChannel(Integer id, String label, String channelType, String command) {
		URLType commandVal = new URLType(command);
		return new SongURLChannel(id, label, channelType, commandVal);
	}

	public static TriggerChannel createTriggerChannel(Integer id, String label, String channelType, String command) {
		return new TriggerChannel(id, label, channelType, TriggerType.getCommandValueFromString(command));
	}

	public static Channel createVolumeChannel(Integer id, String label, String channelType, String command) {
		NumberType commandVal = new NumberType(command, 0, 100);
		return new VolumeChannel(id, label, channelType, commandVal);
	}
	
	public static Channel createColorChannel(Integer id, String label, String channelType, String command) {
		ColorType commandVal = new ColorType(command);
		
		return new ColorChannel(id, label, channelType, commandVal);
	}
	
	public static Channel createHumidityChannel(Integer id, String label, String channelType, String command) {
		NumberType commandVal = new NumberType(command, 0, 100);
		
		return new HumidityChannel(id, label, channelType, commandVal);
	}
	
	public static Channel createTemperatureChannel(Integer id, String label, String channelType, String command) {
		NumberType commandVal = new NumberType(command, -100, 100);
		
		return new TemperatureChannel(id, label, channelType, commandVal);
	}
}
