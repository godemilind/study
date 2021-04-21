package com.iocs.spring.beans.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lifecycle")
public class LifecycleController {
    Logger logger = LoggerFactory.getLogger(LifecycleController.class);

    @Autowired
    private BeanLifecycleAnnotations beanLifecycleAnnotations;

    @Autowired
    private BeanLifecycleInterfaces beanLifecycleInterfaces;

    @GetMapping(value = "/testLCAnnotations",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> testBeanLifecycleAnnotations(){
        System.out.println(beanLifecycleAnnotations);
        return ResponseEntity.ok("Success");
    }

    @GetMapping(value = "/testLCInterfaces",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> testBeanLifecycleInterfaces(){
        System.out.println(beanLifecycleInterfaces);
        return ResponseEntity.ok("Success");
    }
}
