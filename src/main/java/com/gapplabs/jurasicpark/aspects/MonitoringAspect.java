package com.gapplabs.jurasicpark.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MonitoringAspect {

    private static final Logger logger = Logger.getLogger(MonitoringAspect.class.getName());

    @Around("execution(* com.gapplabs.jurasicpark.services.*.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); // Ejecuta el método original
        long executionTime = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature().getName() + " ejecutado en " + executionTime + "ms");
        return proceed;
    }
}
