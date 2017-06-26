package com.musala.sdcs.devices.builder;

import com.musala.sdcs.devices.MotionSensor;
import com.musala.sdcs.devices.builder.base.AbstractDeviceBuilder;

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
                this.getFirmwareVersion(), this.getHardwareVersion(), this.getLabel());
    }
}
