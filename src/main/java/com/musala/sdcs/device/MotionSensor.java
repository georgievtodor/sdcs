package com.musala.sdcs.device;

import java.util.List;

import com.musala.sdcs.device.base.AbstractDevice;
import com.musala.sdcs.device.channel.base.AbstractChannel;

/**
 * Concrete implementation of motion sensor that extends {@link AbstractDevice}
 *
 */
public class MotionSensor extends AbstractDevice {

    public MotionSensor(String manufacturer, String modelId, String serialNumber, String firmwareVersion,
            int hardwareVersion, String label, List<AbstractChannel> channels) {
        super(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label, channels);
    }
}
