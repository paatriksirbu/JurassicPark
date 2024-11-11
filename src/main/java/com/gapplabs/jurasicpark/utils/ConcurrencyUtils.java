package com.gapplabs.jurasicpark.utils;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ConcurrencyUtils {

    // Procesa los datos concurrentemente utilizando un Scheduler específico
    public static <T> Flux<T> processConcurrently(Flux<T> dataStream) {
        return dataStream.publishOn(Schedulers.parallel()) // Ejecuta en paralelo
                .onBackpressureBuffer(); // Aplica backpressure
    }

    // Cambia el Scheduler para un procesamiento específico, si es necesario
    public static <T> Flux<T> switchScheduler(Flux<T> dataStream, Scheduler scheduler) {
        return dataStream.subscribeOn(scheduler);
    }

    // Aplica un backpressure especial para flujos rápidos
    public static <T> Flux<T> applyCustomBackpressure(Flux<T> dataStream) {
        return dataStream.onBackpressureDrop(); // Solución de backpressure por omisión
    }
}
