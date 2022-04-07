package com.iocs.spring.beans.async;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsyncControllerTest {

    private Logger log = LoggerFactory.getLogger(AsyncControllerTest.class);

    @LocalServerPort
    int randomPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test(){
        log.info(this.restTemplate.getForObject("http://localhost:" + randomPort + "/async/asyncTest",String.class));
    }
}
