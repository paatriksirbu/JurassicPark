package com.gapplabs.jurasicpark.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class NotificationAspect {

    private static final Logger logger = Logger.getLogger(NotificationAspect.class.getName());

    @Before("execution(* com.gapplabs.jurasicpark.services.NotificationService.sendNotification(..))")
    public void logBeforeSendNotification(JoinPoint joinPoint) {
        // Registro de los parámetros del método
        Object[] args = joinPoint.getArgs();
        String message = (String) args[0];
        String recipient = (String) args[1];
        logger.info("Attempting to send notification to " + recipient + " with message: " + message);
    }

    @AfterReturning(pointcut = "execution(* com.gapplabs.jurasicpark.services.NotificationService.sendNotification(..))", returning = "result")
    public void logAfterSendNotification(JoinPoint joinPoint, Object result) {
        // Registro del resultado devuelto por el método
        logger.info("Completed sendNotification for " + joinPoint.getSignature().getName() + " with result: " + result);
    }
}
