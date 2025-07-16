package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("Class: " + joinPoint.getTarget().getClass().getName());
    }

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logAfterSuccess(JoinPoint joinPoint) {
        LOGGER.info("Method: " + joinPoint.getSignature().getName() + " finished successfully");
    }

    @AfterThrowing(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))", throwing = "ex")
    public void logAfterException(JoinPoint joinPoint, Throwable ex) {
        LOGGER.error("Exception in method: " + joinPoint.getSignature().getName() + ", exception: " + ex.getMessage());
    }
}
