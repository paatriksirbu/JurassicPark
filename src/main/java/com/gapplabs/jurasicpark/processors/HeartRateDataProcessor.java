package com.gapplabs.jurasicpark.processors;


import com.gapplabs.jurasicpark.utils.AlertUtils;
import reactor.core.publisher.Flux;

public class HeartRateDataProcessor extends DataProcessor<Integer> {

    private static final int HEART_RATE_THRESHOLD = 100; // Umbral de frecuencia cardíaca alta

    @Override
    protected Flux<Integer> process(Integer data) {
        if (data > HEART_RATE_THRESHOLD) {
            AlertUtils.sendAlert(data, "High heart rate detected!");
        }
        return Flux.just(data); // Retorna el dato para continuar con la cadena de procesamiento
    }

    @Override
    protected void publishResult(Integer result) {
        System.out.println("Processed heart rate data: " + result);
    }
}
