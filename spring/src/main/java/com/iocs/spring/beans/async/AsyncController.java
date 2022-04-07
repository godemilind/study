package com.iocs.spring.beans.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping(value = "/asyncTest",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> testException() throws Exception{
        asyncService.asyncMethodWithVoidReturnType();
        return ResponseEntity.ok(asyncService.asyncMethodWithReturnType().get());
    }
}
