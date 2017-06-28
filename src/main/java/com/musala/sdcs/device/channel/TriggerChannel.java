package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.TriggerType;

/**
 * this class defines trigger channel
 *
 */
public class TriggerChannel extends AbstractChannel<TriggerType> {

    public TriggerChannel(String label, TriggerType command) {
        super(label, command);
    }

    @Override
    public void executeCommand(TriggerType command) {
        super.executeCommand(command);

        switch (command) {
            case On:
                // TODO: Implement logic
                break;
            case Off:
                // TODO: Implement logic
                break;
            default:
                break;
        }
    }
}
