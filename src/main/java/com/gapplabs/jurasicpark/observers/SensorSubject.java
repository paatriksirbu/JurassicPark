package com.gapplabs.jurasicpark.observers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SensorSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String sensorData) {
        for (Observer observer : observers) {
            executor.submit(() -> observer.update(sensorData));
        }
    }
}
