package com.musala.sdcs;


import com.musala.sdcs.devices.MotionSensor;
import com.musala.sdcs.devices.MotionSensorBuilder;

public class Startup {

    public static void main(String[] args) {
        MotionSensorBuilder builder = new MotionSensorBuilder();
        builder.withLabel("Thinkpad").withManufacturer("Lenovo");
        MotionSensor sensor = MotionSensorBuilder.getInstance().withLabel("Thinkpad").withManufacturer("Lenovo").build();
        
        System.out.println(sensor.getLabel() + " " + sensor.getManufacturer());
        
    }
}