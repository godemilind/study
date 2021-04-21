package com.iocs.spring.beans.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scope")
public class RequestScopeController {

    @Autowired
    private RequestScopeBean requestScopeBean;

    @Autowired
    private SessionScopeBean sessionScopeBean;

    @GetMapping(value="/requestScope",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testRequestScope(){
        System.out.println(requestScopeBean);
        return ResponseEntity.ok("Success");
    }

    @GetMapping(value = "/sessionScope",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testSessionScope(){
        System.out.println(sessionScopeBean);
        return ResponseEntity.ok("Success");
    }
}
