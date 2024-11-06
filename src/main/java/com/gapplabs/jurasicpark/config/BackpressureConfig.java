package com.gapplabs.jurasicpark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Schedulers;

@Configuration
public class BackpressureConfig {

    @Bean
    public Schedulers defaultSchedulers() {
        // Configuramos el Schedulers por defecto para que sea el boundedElastic y manejar la concurrencia.
        return (Schedulers) Schedulers.boundedElastic();
    }
}
