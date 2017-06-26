package com.musala.sdcs.devices;

import com.musala.sdcs.devices.base.AbstractDevice;

/**
 * Concrete implementation of motion sensor that extends {@link AbstractDevice}
 *
 */
public class MotionSensor extends AbstractDevice {

    public MotionSensor(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label) {
        super(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label);
    }
}
