package com.iocs.spring.beans.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logging")
public class SpringLoggingController {

    private Logger logger = LoggerFactory.getLogger(SpringLoggingController.class);

    @GetMapping(value = "/testLogging", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testLogging(){
        logger.info("INFO");
        logger.warn("WARN");
        logger.error("ERROR");
        logger.debug("DEBUG");
        logger.trace("TRACE");
        return ResponseEntity.ok("Success");
    }
}

