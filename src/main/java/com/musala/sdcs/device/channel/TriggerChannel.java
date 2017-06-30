package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.TriggerType;

/**
 * This class defines trigger channel
 *
 */
public class TriggerChannel extends AbstractChannel<TriggerType> {

    public TriggerChannel(Integer id, String label, TriggerType command) {
        super(id, label, command);
    }

    @Override
    public void executeCommand(TriggerType command) {
        super.executeCommand(command);

    }
}
