package com.gapplabs.jurasicpark.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class NotificationService {

    @Async
    public CompletableFuture<String> sendNotification(String message, String recipient) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulación del envío de una notificación (demora simulada)
                Thread.sleep(1000); // Simula la demora del envío
                System.out.println("Notification sent to " + recipient + ": " + message);
                return "Notification sent successfully";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Failed to send notification";
            }
        });
    }
}
