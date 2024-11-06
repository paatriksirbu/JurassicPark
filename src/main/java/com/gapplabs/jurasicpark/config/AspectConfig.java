package com.gapplabs.jurasicpark.config;

import com.gapplabs.jurasicpark.aspects.LoggingAspect;
import com.gapplabs.jurasicpark.aspects.MonitoringAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // Habilitamos el uso de aspectos
public class AspectConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public BackpressureConfig backpressureConfig() {
        return new BackpressureConfig();
    }

    @Bean
    public SecurityConfig securityConfig() {
        return new SecurityConfig();
    }

    @Bean
    public MonitoringAspect monitoringAspect() {
        return new MonitoringAspect();
    }
}
