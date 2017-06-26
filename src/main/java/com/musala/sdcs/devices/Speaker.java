package com.musala.sdcs.devices;

import com.musala.sdcs.devices.base.AbstractDevice;

/**
 * Concrete implementation of speaker that extends {@link AbstractDevice}
 *
 */
public class Speaker extends AbstractDevice {

    private PlayControlType controllType;
    private int volume;
    private String songUrl = "";

    public Speaker(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label, PlayControlType controllType, int volume) {
        super(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label);
        this.setControllType(controllType);
        this.setVolume(volume);
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
