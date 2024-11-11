package com.gapplabs.jurasicpark.services;

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


}
