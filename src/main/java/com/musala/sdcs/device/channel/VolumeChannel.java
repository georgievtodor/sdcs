package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * This class defines volume channel
 *
 */
public class VolumeChannel extends AbstractChannel<String> {

    public VolumeChannel(Integer id, String label, String command) {
        super(id, label, command);
    }

    @Override
    public void executeCommand(String command) {
        super.executeCommand(command);
    }

}
