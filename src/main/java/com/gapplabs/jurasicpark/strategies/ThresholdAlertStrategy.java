// ThresholdAlertStrategy.java
package com.gapplabs.jurasicpark.strategies;

import com.gapplabs.jurasicpark.utils.AlertUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ThresholdAlertStrategy implements AlertStrategy {

    private final double threshold;
    private final String alertMessage;

    public ThresholdAlertStrategy(double threshold, String alertMessage) {
        this.threshold = threshold;
        this.alertMessage = alertMessage;
    }

    @Override
    public void processData(Flux<Number> dataStream) {
        dataStream.flatMap(data -> {
            if (data.doubleValue() > threshold) {
                return AlertUtils.sendAlert(data, "Threshold exceeded: " + alertMessage)
                        .thenReturn(data);
            }
            return Mono.just(data);
        }).subscribe();  // Suscribir al flujo para que se ejecute.
    }
}
