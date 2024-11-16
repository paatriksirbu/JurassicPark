package com.gapplabs.jurasicpark.observers;

public class SensorObserver implements Observer {

    @Override
    public void update(String sensorData) {
        // Process and observe the sensor data
        System.out.println("Observing sensor data: " + sensorData);

        // Add any specific logic for handling observed data
        // Example: Forward data to another system or filter relevant data
        if (sensorData.contains("INFO")) {
            System.out.println("INFO: Processing additional details from - " + sensorData);
        }
    }
}
