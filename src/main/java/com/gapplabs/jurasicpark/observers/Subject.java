package com.gapplabs.jurasicpark.observers;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String sensorData);
}

