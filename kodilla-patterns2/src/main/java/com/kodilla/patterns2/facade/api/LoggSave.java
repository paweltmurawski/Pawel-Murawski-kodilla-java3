package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggSave {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggSave.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
    "&& args(order, userId) && target(object)")
    public void methodExecution(OrderDto order, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", method: " + order + ", " + userId);
    }

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void methodExecutionSucceed() {
        LOGGER.info("Execution of method was successful");
    }

    @AfterThrowing("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void methodExecutionFailed() {
        LOGGER.info("Something went wrong");
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object timeOfExecutingMethod(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time of method execution: " + (end - begin) + " [ms]");
        } catch (Throwable throwable) {
            LOGGER.error("Execution of method processOrder failed");
            throw throwable;
        }
        return result;
    }
}
