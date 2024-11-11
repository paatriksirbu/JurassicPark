package com.gapplabs.jurasicpark.services;

import com.gapplabs.jurasicpark.models.Alert;
import com.gapplabs.jurasicpark.repositories.AlertRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    private static final Logger logger = LoggerFactory.getLogger(AlertService.class);
    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }


}
