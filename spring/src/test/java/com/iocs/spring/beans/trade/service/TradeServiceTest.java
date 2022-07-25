package com.iocs.spring.beans.trade.service;

import com.iocs.spring.beans.trade.TradingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeFormatter;

//@RunWith(SpringRunner.class)
@RestClientTest
public class TradeServiceTest {

    @Autowired
    private TradingController controller;

    public void testRest(){
        System.out.println(controller);
    }


}
