package com.musala.sdcs.devices;

import com.musala.sdcs.devices.base.Device;

public class Speaker extends Device {

    private PlayControllType controllType;
    private int volume;
    private String songUrl = "";

    public Speaker(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label, PlayControllType controllType, int volume) {
        super(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label);
        this.setControllType(controllType);
        this.setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public PlayControllType getControllType() {
        return controllType;
    }

    public void setControllType(PlayControllType controllType) {
        this.controllType = controllType;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

}
