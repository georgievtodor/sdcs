package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * This class defines song URL channel
 *
 */
public class SongURLChannel extends AbstractChannel<String> {

    public SongURLChannel(Integer id, String label, String command) {
        super(id, label, command);
    }

    @Override
    public void executeCommand(String command) {
        super.executeCommand(command);

    }
}
