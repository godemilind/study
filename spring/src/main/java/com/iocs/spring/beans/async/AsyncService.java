package com.iocs.spring.beans.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

    private Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public Future<String> asyncMethodWithReturnType() {
        logger.info("Execute method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<>("hello world !!!!");
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    @Async
    public void asyncMethodWithVoidReturnType() {
        logger.info("Execute method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            String x = null;
            //x.toString();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
