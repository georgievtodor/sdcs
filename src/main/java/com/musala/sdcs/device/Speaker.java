package com.musala.sdcs.device;

import java.util.List;

import com.musala.sdcs.device.base.AbstractDevice;
import com.musala.sdcs.device.channel.base.AbstractChannel;
import com.musala.sdcs.device.channel.type.PlayControlType;

/**
 * Concrete implementation of speaker that extends {@link AbstractDevice}
 *
 */
public class Speaker extends AbstractDevice {

    private PlayControlType controllType;
    private int volume;
    private String songUrl = "";

    public Speaker(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label, List<AbstractChannel> channels) {
        super(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label, channels);
    }

    /**
     * @return the current volume of the speaker
     */
    public int getVolume() {
        return volume;
    }

    /**
     * sets the volume of the speaker
     * 
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the current state type of the play/pause channel
     */
    public PlayControlType getControllType() {
        return controllType;
    }

    /**
     * sets the current state type of the play/pause channel
     * 
     * @param controllType
     */
    public void setControllType(PlayControlType controllType) {
        this.controllType = controllType;
    }

    /**
     * @return the song url
     */
    public String getSongUrl() {
        return songUrl;
    }

    /**
     * sets the song url
     * 
     * @param songUrl
     */
    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

}
