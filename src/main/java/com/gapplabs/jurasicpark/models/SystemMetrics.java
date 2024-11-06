package com.gapplabs.jurasicpark.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemMetrics {
    private String metricName;
    private Double value;
    private Long timestamp;

    // Constructor vacio. Lo creamos para que el compilador no nos de errores en caso de que no lo usemos
    public SystemMetrics() {}

    // Constructor con todos los atributos
    public SystemMetrics(String metricName, Double value, Long timestamp) {
        this.metricName = metricName;
        this.value = value;
        this.timestamp = timestamp;
    }
}
