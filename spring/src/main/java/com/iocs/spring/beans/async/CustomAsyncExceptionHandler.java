package com.iocs.spring.beans.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(CustomAsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(
            Throwable throwable, Method method, Object... obj) {

        logger.info("Exception message - " + throwable.getMessage());
        logger.info("Method name - " + method.getName());
        for (Object param : obj) {
            logger.error("Parameter value - " + param);
        }
    }

}