package com.gapplabs.jurasicpark.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* com.gapplabs.jurasicpark.services.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Método invocado " + joinPoint.getSignature().getName() + " Con argumentos " + java.util.Arrays.toString(joinPoint.getArgs()));
    }
}
