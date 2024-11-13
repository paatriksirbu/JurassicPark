package com.gapplabs.jurasicpark.controllers;

import com.gapplabs.jurasicpark.models.Monitoring;
import com.gapplabs.jurasicpark.services.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/monitoring")
public class MonitoringController {

    private final MonitoringService monitoringService;

    @Autowired
    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> createMonitoring(@RequestBody Monitoring monitoring) {
        return monitoringService.saveMonitoring(monitoring)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .exceptionally(ex -> new ResponseEntity<>("Error creating monitoring: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Monitoring>>> getAllMonitoringRecords() {
        return monitoringService.getAllMonitoringRecords()
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<String>> deleteMonitoringById(@PathVariable String id) {
        return monitoringService.deleteMonitoring(id)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .exceptionally(ex -> new ResponseEntity<>("Monitoring not found: " + ex.getMessage(), HttpStatus.NOT_FOUND));
    }
}

