package com.gapplabs.jurasicpark;

import com.gapplabs.jurasicpark.models.Dinosaur;
import com.gapplabs.jurasicpark.models.SensorData;
import com.gapplabs.jurasicpark.observers.*;
import com.gapplabs.jurasicpark.processors.DataProcessor;
import com.gapplabs.jurasicpark.services.SensorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class JurasicParkApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JurasicParkApplication.class, args);

        // Thread Pool for Concurrent Processing
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Create Subject and Observers
        SensorSubject sensorSubject = new SensorSubject();
        AlertObserver alertObserver = new AlertObserver();
        MetricsObserver metricsObserver = new MetricsObserver();
        SensorDataLogger sensorDataLogger = new SensorDataLogger();
        SensorObserver sensorObserver = new SensorObserver();

        // Register Observers
        sensorSubject.registerObserver(alertObserver);
        sensorSubject.registerObserver(metricsObserver);
        sensorSubject.registerObserver(sensorDataLogger);
        sensorSubject.registerObserver(sensorObserver);

        // Simulate Sensor Data with Multi-threading
        executor.submit(() -> simulateSensorData(sensorSubject, "Temperature: 30C"));
        executor.submit(() -> simulateSensorData(sensorSubject, "Movement: Running"));
        executor.submit(() -> simulateSensorData(sensorSubject, "CRITICAL: Heart Rate Drop"));
        executor.submit(() -> simulateSensorData(sensorSubject, "Temperature: 45C"));
        executor.submit(() -> simulateSensorData(sensorSubject, "INFO: Normal Operation"));

        // Simulate Dinosaur Actions with Multi-threading
        executor.submit(() -> simulateDinosaurAction("Tyrannosaurus Rex", "Running"));
        executor.submit(() -> simulateDinosaurAction("Brachiosaurus", "Eating Leaves"));
        executor.submit(() -> simulateDinosaurAction("Velociraptor", "Hunting"));

        executor.shutdown();
    }

    // Simulate sensor data input
    private static void simulateSensorData(SensorSubject sensorSubject, String data) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[Thread: " + threadName + "] Sending sensor data: " + data);
        sensorSubject.notifyObservers(data);
    }

    // Simulate dinosaur actions
    private static void simulateDinosaurAction(String dinosaur, String action) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[Thread: " + threadName + "] Dinosaur Action: " + dinosaur + " is " + action);
    }
}
