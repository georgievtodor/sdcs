package com.musala.sdcs.devices;

import com.musala.sdcs.devices.base.Device;

public class MotionSensor extends Device {

    public MotionSensor(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label) {
        super(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label);
    }
}
