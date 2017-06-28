package com.musala.sdcs.device.channel;

import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.PlayControlType;

/**
 * this class defines song control channel
 *
 */
public class SongControlChannel extends AbstractChannel<PlayControlType> {

    public SongControlChannel(String label, PlayControlType command) {
        super(label, command);
    }

    @Override
    public void executeCommand(PlayControlType command) {
        super.executeCommand(command);
        switch (command) {
            case Play:
                // TODO: Implement logic
                break;
            case Pause:
                // TODO: Implement logic
                break;
            case Stop:
                // TODO: Implement logic
                break;
            default:
                break;
        }
    }
}
