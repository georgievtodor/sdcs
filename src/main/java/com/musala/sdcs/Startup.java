package com.musala.sdcs;

import java.sql.SQLException;
import java.util.List;

import com.musala.sdcs.device.Device;
import com.musala.sdcs.device.channel.SongControlChannel;
import com.musala.sdcs.device.channel.base.Channel;
import com.musala.sdcs.device.channel.type.PlayControlType;
import com.musala.sdcs.jdbc.DeviceRepository;

public class Startup {
	
    public static void main(String[] args) throws SQLException {
        DeviceRepository repo = new DeviceRepository();
        List<Device> devices = repo.getAllDevices();
        SongControlChannel ch = (SongControlChannel) devices.get(0).getChannels().get(2);
        ch.executeCommand(PlayControlType.Pause);
        
        for(Device device: devices) {
        	System.out.println("id: " + device.getId() + ", label: " + device.getLabel() + ", firmware version: " + device.getFirmwareVersion()
        	 + ", hardware version: " + device.getHardwareVersion() + ", serial number: " + device.getSerialNumber() + ", model: " + device.getModelId()
        	 + ", manufacturer: " + device.getManufacturer());
        	
        	System.out.println("Channels:");
        	for(Channel chs: device.getChannels()) {
        		System.out.println(chs.getLabel());
        	}
        }
    }
}