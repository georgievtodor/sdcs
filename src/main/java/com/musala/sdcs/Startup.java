package com.musala.sdcs;

import com.musala.sdcs.devices.MotionSensor;
import com.musala.sdcs.devices.builder.MotionSensorBuilder;

public class Startup {

    public static void main(String[] args) {
        MotionSensor sensor = MotionSensorBuilder.getInstance().withLabel("Thinkpad").withManufacturer("Lenovo")
                .build();

        System.out.println(String.format("%s %s", sensor.getLabel(), sensor.getManufacturer()));

    }
}