// AnomalyDetectionAlertStrategy.java
package com.gapplabs.jurasicpark.strategies;

import com.gapplabs.jurasicpark.utils.AlertUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AnomalyDetectionAlertStrategy implements AlertStrategy {

    private final double threshold;
    private final String sensorType;
    private final String alertMessage;

    public AnomalyDetectionAlertStrategy(String alertMessage, double threshold, String sensorType) {
        this.alertMessage = alertMessage;
        this.threshold = threshold;
        this.sensorType = sensorType;
    }

    @Override
    public void processData(Flux<Number> dataStream) {
        dataStream.flatMap(data -> {
            if (data.doubleValue() > threshold) {
                return AlertUtils.sendAlert(data, sensorType + " anomaly detected: " + alertMessage)
                        .thenReturn(data);
            }
            return Mono.just(data);
        }).subscribe(); // Importante: realizar la suscripción para que se ejecute el flujo
    }
}
