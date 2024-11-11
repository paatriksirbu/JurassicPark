package com.gapplabs.jurasicpark.services;

import com.gapplabs.jurasicpark.models.SensorData;
import com.gapplabs.jurasicpark.repositories.SensorDataRepository;
import org.springframework.stereotype.Service;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class SensorDataProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(SensorDataProcessingService.class);
    private final SensorDataRepository sensorDataRepository;

    public SensorDataProcessingService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public CompletableFuture<String> saveSensorData(SensorData sensorData) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WriteResult result = sensorDataRepository.saveSensorData(sensorData).get();
                logger.info("Datos del sensor guardados correctamente: " + result);
                return result.getUpdateTime().toString();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al guardar los datos del sensor: " + e.getMessage());
                throw new RuntimeException("Error al guardar los datos del sensor: " + e.getMessage());
            }
        });
    }

    @Async
    public CompletableFuture<List<SensorData>> getAllSensorData() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                QuerySnapshot querySnapshot = sensorDataRepository.getAllSensorData().get();
                return querySnapshot.getDocuments().stream()
                        .map(document -> document.toObject(SensorData.class))
                        .collect(Collectors.toList());
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al obtener los datos del sensor: {}", e.getMessage());
                throw new RuntimeException("Error al obtener los datos del sensor", e);
            }
        });
    }

    public CompletableFuture<String> deleteSensorData(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WriteResult result = sensorDataRepository.deleteSensorData(id).get();
                logger.info("Datos del sensor eliminados correctamente: " + result);
                return result.getUpdateTime().toString();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al eliminar los datos del sensor: " + e.getMessage());
                throw new RuntimeException("Error al eliminar los datos del sensor: " + e.getMessage());
            }
        });
    }
}
