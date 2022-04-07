package com.iocs.spring.beans.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExceptionControllerTest {

    @LocalServerPort
    int randomPort;

    @Autowired
    ExceptionController exceptionController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() throws Exception {
        this.restTemplate.getForObject("http://localhost:" + randomPort + "/",String.class);
        //exceptionController.testException();
    }
}
