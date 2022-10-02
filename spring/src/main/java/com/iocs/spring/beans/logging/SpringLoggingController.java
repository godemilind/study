package com.iocs.spring.beans.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logging")
@Slf4j
public class SpringLoggingController {

    @GetMapping(value = "/testLogging", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testLogging(){
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");
        return ResponseEntity.ok("Success");
    }
}

