package com.gapplabs.jurasicpark.services;

import com.gapplabs.jurasicpark.models.Alert;
import com.gapplabs.jurasicpark.repositories.AlertRepository;
import com.google.cloud.firestore.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

}
