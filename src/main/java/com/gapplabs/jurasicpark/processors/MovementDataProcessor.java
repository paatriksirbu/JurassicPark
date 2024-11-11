package com.gapplabs.jurasicpark.processors;

import com.gapplabs.jurasicpark.utils.AlertUtils;
import reactor.core.publisher.Flux;

public class MovementDataProcessor extends DataProcessor<Integer> {

    private static final int MOVEMENT_THRESHOLD = 75; // Nivel de actividad alta

    @Override
    protected Flux<Integer> process(Integer data) {
        if (data > MOVEMENT_THRESHOLD) {
            AlertUtils.sendAlert(data, "High movement detected!");
        }
        return Flux.just(data); // Retorna el dato para continuar con la cadena de procesamiento
    }

    @Override
    protected void publishResult(Integer result) {
        System.out.println("Processed movement data: " + result);
    }
}
