package com.gapplabs.jurasicpark.services;

import com.gapplabs.jurasicpark.models.Alert;
import com.gapplabs.jurasicpark.repositories.AlertRepository;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class AlertService {

    private static final Logger logger = LoggerFactory.getLogger(AlertService.class);
    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public CompletableFuture<String> saveAlert(Alert alert) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WriteResult result = alertRepository.saveAlert(alert).get();
                logger.info("Alerta guardada correctamente: " + result);
                return result.getUpdateTime().toString();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al guardar la alerta: " + e.getMessage());
                throw new RuntimeException("Error al guardar la alerta: " + e.getMessage());
            }
        });
    }

    @Async
    public CompletableFuture<List<Alert>> getAllAlerts() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                QuerySnapshot querySnapshot = alertRepository.getAllAlerts().get();
                return querySnapshot.getDocuments().stream()
                        .map(document -> document.toObject(Alert.class))
                        .collect(Collectors.toList());
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al obtener las alertas: {}", e.getMessage());
                throw new RuntimeException("Error al obtener las alertas", e);
            }
        });
    }

    public CompletableFuture<String> deleteAlert(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WriteResult result = alertRepository.deleteAlert(id).get();
                logger.info("Alerta eliminada correctamente: " + result);
                return result.getUpdateTime().toString();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Error al eliminar la alerta: " + e.getMessage());
                throw new RuntimeException("Error al eliminar la alerta: " + e.getMessage());
            }
        });
    }
}
