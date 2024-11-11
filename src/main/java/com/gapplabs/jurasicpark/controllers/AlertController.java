package com.gapplabs.jurasicpark.controllers;

import com.gapplabs.jurasicpark.models.Alert;
import com.gapplabs.jurasicpark.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> createAlert(@RequestBody Alert alert) {
        return alertService.saveAlert(alert)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.CREATED));
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Alert>>> getAllAlerts() {
        return alertService.getAllAlerts()
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<String>> deleteAlertById(@PathVariable String id) {
        return alertService.deleteAlert(id)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .exceptionally(ex -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
