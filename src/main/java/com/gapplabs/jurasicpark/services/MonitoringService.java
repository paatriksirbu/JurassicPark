package com.gapplabs.jurasicpark.services;

import com.gapplabs.jurasicpark.models.Monitoring;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class MonitoringService {

    // Simulación de una base de datos con concurrencia
    private final List<Monitoring> monitoringDatabase = new ArrayList<>();

    // Método para guardar un nuevo registro de monitoreo
    @Async
    public CompletableFuture<String> saveMonitoring(Monitoring monitoring) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (monitoringDatabase) {
                monitoringDatabase.add(monitoring); // Simula la inserción en la "base de datos"
            }
            return "Monitoring record created successfully";
        });
    }

    // Método para obtener todos los registros de monitoreo
    @Async
    public CompletableFuture<List<Monitoring>> getAllMonitoringRecords() {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (monitoringDatabase) {
                return new ArrayList<>(monitoringDatabase); // Retorna una copia de los registros
            }
        });
    }

    // Método para eliminar un registro de monitoreo por ID
    @Async
    public CompletableFuture<String> deleteMonitoring(String id) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (monitoringDatabase) {
                Optional<Monitoring> record = monitoringDatabase.stream()
                        .filter(m -> m.getId().equals(id))
                        .findFirst();
                if (record.isPresent()) {
                    monitoringDatabase.remove(record.get());
                    return "Monitoring record deleted successfully";
                } else {
                    throw new RuntimeException("Monitoring record not found");
                }
            }
        });
    }
}
