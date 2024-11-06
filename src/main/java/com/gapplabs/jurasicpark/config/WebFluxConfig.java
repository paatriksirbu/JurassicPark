package com.gapplabs.jurasicpark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
public class WebFluxConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(200);
        executor.setThreadNamePrefix("JurassicTaskExecutor-");
        executor.initialize();
        return executor;
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("JurassicTaskScheduler-");
        scheduler.initialize();
        return scheduler;
    }
}
