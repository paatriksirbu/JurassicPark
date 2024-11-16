package com.gapplabs.jurasicpark.observers;


public class MetricsObserver implements Observer {

    private int dataCount = 0;
    private int dataSum = 0;

    @Override
    public void update(String sensorData) {
        try {
            int value = Integer.parseInt(sensorData);
            dataSum += value;
            dataCount++;
            if (dataCount == 10) {
                double average = dataSum / 10.0;
                System.out.println("Average value: " + average);
                dataSum = 0;
                dataCount = 0;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid data received: " + sensorData);
        }
    }
}
