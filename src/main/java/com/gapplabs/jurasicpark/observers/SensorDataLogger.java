package com.gapplabs.jurasicpark.observers;

public class SensorDataLogger implements Observer {

    @Override
    public void update(String sensorData) {
        System.out.println("LOG: Data received - " + sensorData);
    }
}
