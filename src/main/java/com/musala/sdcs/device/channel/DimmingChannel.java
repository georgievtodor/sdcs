package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * This class defines dimming channel
 *
 */
public class DimmingChannel extends AbstractChannel<String> {

    public DimmingChannel(Integer id, String label, String command) {
        super(id, label, command);
    }

    @Override
    public void executeCommand(String command) {
        super.executeCommand(command);

        // TODO: Implement method logic
    }

}
