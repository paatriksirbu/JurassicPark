package com.gapplabs.jurasicpark.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class AlertUtils {

    private static final Logger logger = LoggerFactory.getLogger(AlertUtils.class);

    // Envía alerta cuando se detectan datos anómalos en los sensores
    public static <T> Mono<Void> sendAlert(T data, String alertType) {
        return Mono.fromRunnable(() -> logger.warn("ALERTA: " + alertType + " detectado en datos: " + data));
    }

    // Verifica y envía alertas si los datos superan un umbral específico
    public static <T extends Number> Mono<Void> checkAndAlert(T data, double threshold, String alertType) {
        if (data.doubleValue() > threshold) {
            return sendAlert(data, alertType);
        }
        return Mono.empty();
    }
}
