package com.gapplabs.jurasicpark.processors;

import com.gapplabs.jurasicpark.utils.AlertUtils;
import reactor.core.publisher.Flux;

public class TemperatureDataProcessor extends DataProcessor<Double> {

    private static final double TEMPERATURE_THRESHOLD = 30.0; // Umbral de temperatura alta

    @Override
    protected Flux<Double> process(Double data) {
        if (data > TEMPERATURE_THRESHOLD) {
            AlertUtils.sendAlert(data, "Alta temperatura detectada!");
        }
        return Flux.just(data); // Retorna el dato para continuar con la cadena de procesamiento
    }

    @Override
    protected void publishResult(Double result) {
        System.out.println("Resultado" + result);
    }
}
