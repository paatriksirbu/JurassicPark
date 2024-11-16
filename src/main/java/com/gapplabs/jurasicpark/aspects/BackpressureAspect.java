package com.gapplabs.jurasicpark.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

@Aspect
@Component
public class BackpressureAspect {

    private static final Logger logger = Logger.getLogger(BackpressureAspect.class.getName());
    private static final Semaphore semaphore = new Semaphore(5); // Limita a 5 hilos simultáneos

    @Around("execution(* com.gapplabs.jurasicpark.services.*.*(..))")
    public Object limitConcurrency(ProceedingJoinPoint joinPoint) throws Throwable {
        if (semaphore.tryAcquire()) {
            try {
                logger.info("Ejecutando método: " + joinPoint.getSignature().getName() + " con concurrencia controlada.");
                return joinPoint.proceed(); // Ejecuta el método original
            } finally {
                semaphore.release();
                logger.info("Released semaphore for method: " + joinPoint.getSignature().getName());
            }
        } else {
            logger.warning("Backpressure applied. Too many concurrent requests for method: " + joinPoint.getSignature().getName());
            throw new RuntimeException("System is under heavy load. Please try again later.");
        }
    }
}
