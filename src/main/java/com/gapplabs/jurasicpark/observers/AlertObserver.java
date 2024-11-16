package com.gapplabs.jurasicpark.observers;

public class AlertObserver implements Observer {

    @Override
    public void update(String sensorData) {
        if (sensorData.contains("CRITICAL")) {
            System.out.println("ALERT: Critical issue detected - " + sensorData);
        }
    }
}
