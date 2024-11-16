package com.gapplabs.jurasicpark.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class SecurityAspect {

    private static final Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Before("execution(* com.gapplabs.jurasicpark.services.*.*(..))")
    public void checkSecurity(JoinPoint joinPoint) {
        // Simulación de verificación de seguridad
        logger.info("Security check before executing method: " + joinPoint.getSignature().getName());

    }
}
