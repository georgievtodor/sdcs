package com.musala.sdcs;


import com.musala.sdcs.device.MotionSensor;
import com.musala.sdcs.device.builder.MotionSensorBuilder;

public class Startup {
    public static void main(String[] args) {

        MotionSensor sensor = MotionSensorBuilder.getInstance().withLabel("Thinkpad").withManufacturer("Lenovo")
                .build();
        
        
        
        System.out.println(String.format("%s %s", sensor.getLabel(), sensor.getManufacturer()));
    }
}