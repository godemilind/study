package com.iocs.spring.beans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping(value = "/testException",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testException() throws Exception{
        if(true)throw new Exception("Test Error");
            return ResponseEntity.ok("Success");
    }

    @GetMapping(value = "/testException2",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testException2() throws Exception{
        try {
            if(true)throw new Exception("Test Error");
            return ResponseEntity.ok("Success");
        }catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }
}
