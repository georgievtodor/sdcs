package com.musala.sdcs;

import java.util.ArrayList;
import java.util.List;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.builder.DeviceBuilderImpl;
import com.musala.sdcs.device.channel.SongControlChannel;
import com.musala.sdcs.device.channel.SongURLChannel;
import com.musala.sdcs.device.channel.VolumeChannel;
import com.musala.sdcs.device.channel.base.Channel;
import com.musala.sdcs.device.channel.type.PlayControlType;

public class Startup {
    public static void main(String[] args) {
        List<Channel> channels = new ArrayList<Channel>();

        Channel volume = new VolumeChannel("Volume", "30");
        Channel url = new SongURLChannel("song url", "https://google.com");
        Channel songControl = new SongControlChannel("Song control", PlayControlType.Play);

        channels.add(volume);
        channels.add(url);
        channels.add(songControl);

        String label = "90's best";
        String firmwareVersion = "some firmware version";
        Integer hardwareVersion = 1;
        String manufacturer = "Sony Ericsson";
        String modelId = "Walkman";
        String serialNumber = "1st";

        Device speaker = DeviceBuilderImpl.getInstance().withLabel(label).withFirmwareVersion(firmwareVersion)
                .withHardwareVersion(hardwareVersion).withManufacturer(manufacturer).withModelId(modelId).withSerialNumber(serialNumber)
                .withChannels(channels).build();

        System.out.println(speaker.getModelId());
    }
}