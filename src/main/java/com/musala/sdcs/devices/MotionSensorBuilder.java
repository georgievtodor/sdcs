package com.musala.sdcs.devices;

public class MotionSensorBuilder {
    
    private String manufacturer = "";
    private String modelId = "";
    private String serialNumber = "";
    private String firmwareVersion = "";
    private int hardwareVersion = 0;
    private String label = "";
    
    public MotionSensorBuilder() {
        
    }
    
    public static MotionSensorBuilder getInstance() {
        return new MotionSensorBuilder();
    }
    
    public MotionSensorBuilder withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
    
    public MotionSensorBuilder withLabel(String label) {
        this.label = label;
        return this;
    }
    
    public MotionSensor build() {
        return new MotionSensor(manufacturer, modelId, serialNumber, firmwareVersion, hardwareVersion, label);
    }
}
