package com.gapplabs.jurasicpark.services;

public class BackpressureService {

    private static final int MAX_TEMPERATURE = 40;
    private static final int MAX_MOVEMENT = 10;

    public void checkTemperature(int temperature) {
        if (temperature > MAX_TEMPERATURE) {
            System.out.println("Temperature is too high: " + temperature);
        }
    }

    public void checkMovement(int movement) {
        if (movement > MAX_MOVEMENT) {
            System.out.println("Movement is too high: " + movement);
        }
    }

    public void checkBackpressure(int temperature, int movement) {
        checkTemperature(temperature);
        checkMovement(movement);
    }


}
