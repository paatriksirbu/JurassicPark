package com.gapplabs.jurasicpark.controllers;


import com.gapplabs.jurasicpark.models.Sensor;
import com.gapplabs.jurasicpark.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> createSensor(@RequestBody Sensor sensor) {
        return sensorService.saveSensor(sensor)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.CREATED));
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Sensor>>> getAllSensors() {
        return sensorService.getAllSensors()
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<String>> deleteSensorById(@PathVariable String id) {
        return sensorService.deleteSensor(id)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .exceptionally(ex -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
