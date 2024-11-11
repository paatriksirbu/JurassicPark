package com.gapplabs.jurasicpark.utils;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

    public class SensorDataUtils {

        //Gestiona la simulacion y la manipulación de datos de sensores (movimiento, temperatura...)


        private static final Random random = new Random();

        // Genera flujo de datos de movimiento simulado
        public static Flux<Integer> getMovementData() {
            return Flux.interval(Duration.ofSeconds(1))
                    .map(tick -> random.nextInt(100))  // Simulación de movimiento (0-100)
                    .onBackpressureDrop();
        }

        // Genera flujo de datos de temperatura simulado
        public static Flux<Double> getTemperatureData() {
            return Flux.interval(Duration.ofSeconds(1))
                    .map(tick -> 20 + (random.nextDouble() * 15)) // Simulación de temperatura (20-35°C)
                    .onBackpressureDrop();
        }

        // Genera flujo de datos de frecuencia cardíaca simulado
        public static Flux<Integer> getHeartRateData() {
            return Flux.interval(Duration.ofSeconds(1))
                    .map(tick -> 60 + random.nextInt(40))  // Simulación de frecuencia cardíaca (60-100 BPM)
                    .onBackpressureDrop();
        }

        // Método utilitario para filtrar datos si superan un umbral
        public static <T extends Number> Flux<T> filterDataAboveThreshold(Flux<T> dataStream, double threshold) {
            return dataStream.filter(data -> data.doubleValue() > threshold);
        }
    }

