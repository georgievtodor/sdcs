package com.musala.sdcs.device.builder;

import com.musala.sdcs.device.MotionSensor;
import com.musala.sdcs.device.builder.base.AbstractDeviceBuilder;

/** 
 * This class allows easy construction of {@link MotionSensor} instance
 *
 */
public class MotionSensorBuilder extends AbstractDeviceBuilder<MotionSensorBuilder> {

    public MotionSensorBuilder() {
        super();
    }

    /**
     * This is factory method
     * 
     * @return new instance of {@link MotionSensorBuilder}
     */
    public static MotionSensorBuilder getInstance() {
        return new MotionSensorBuilder();
    }

    /**
     * @return new instance of {@link MotionSensor}
     */
    public MotionSensor build() {
        return new MotionSensor(this.getManufacturer(), this.getModelId(), this.getSerialNumber(),
                this.getFirmwareVersion(), this.getHardwareVersion(), this.getLabel(), this.getChannels());
    }
}
