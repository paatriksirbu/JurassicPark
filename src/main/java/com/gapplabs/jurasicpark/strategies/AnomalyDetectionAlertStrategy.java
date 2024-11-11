package com.gapplabs.jurasicpark.strategies;

import com.gapplabs.jurasicpark.utils.AlertUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AnomalyDetectionAlertStrategy extends AlertStrategy {

    private final double threshold; // Umbral de detección de anomalías
    private final String sensorType; // Tipo de sensor (ej. "Temperatura", "Frecuencia cardíaca")

    public AnomalyDetectionAlertStrategy(String alertMessage, double threshold, String sensorType) {
        super(alertMessage);
        this.threshold = threshold;
        this.sensorType = sensorType;
    }

    // Método para monitorear el flujo de datos y detectar anomalías
    public <T extends Number> Flux<T> monitorDataStream(Flux<T> dataStream) {
        return dataStream.flatMap(data -> {
            if (data.doubleValue() > threshold) {
                // Enviar alerta usando AlertUtils si se detecta una anomalía
                return AlertUtils.sendAlert(data, sensorType + " anomaly detected: " + getAlertMessage())
                        .thenReturn(data); // Retorna el dato después de enviar la alerta
            }
            return Mono.just(data);
        });
    }

    // Configuración adicional para tipos de alertas específicas
    @Override
    public void execute() {
        System.out.println("Executing anomaly detection strategy for " + sensorType + ": " + getAlertMessage());
    }
}
