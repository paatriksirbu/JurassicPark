package com.gapplabs.jurasicpark.services;

import com.gapplabs.jurasicpark.models.Sensor;
import com.gapplabs.jurasicpark.repositories.SensorRepository;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private static final Logger logger = LoggerFactory.getLogger(SensorService.class);
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public CompletableFuture<String> saveSensor(Sensor sensor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WriteResult result = sensorRepository.saveSensor(sensor).get();
                logger.info("Sensor guardado correctamente: " + result);
                return result.getUpdateTime().toString();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al guardar el sensor: " + e.getMessage());
                throw new RuntimeException("Error al guardar el sensor: " + e.getMessage());
            }
        });
    }

    @Async
    public CompletableFuture<List<Sensor>> getAllSensors(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                QuerySnapshot querySnapshot = sensorRepository.getAllSensors().get();
                return querySnapshot.getDocuments().stream()
                        .map(document -> document.toObject(Sensor.class))
                        .collect(Collectors.toList());
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al obtener los sensores: {}", e.getMessage());
                throw new RuntimeException("Error al obtener los sensores", e);
            }
        });
    }

    public CompletableFuture<String> deleteSensor(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WriteResult result = sensorRepository.deleteSensor(id).get();
                logger.info("Sensor eliminado correctamente: " + result);
                return result.getUpdateTime().toString();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al eliminar el sensor: " + e.getMessage());
                throw new RuntimeException("Error al eliminar el sensor: " + e.getMessage());
            }
        });
    }
}
