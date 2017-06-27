package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * this class defines song url channel
 *
 */
public class SongURLChannel extends AbstractChannel<String> {

    public SongURLChannel(String label, String command) {
        super(label, command);
    }

    @Override
    public void executeCommand(String command) {
        super.executeCommand(command);

        // TODO: Implement method logic
    }
}
