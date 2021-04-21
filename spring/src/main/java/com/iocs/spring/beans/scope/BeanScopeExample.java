package com.iocs.spring.beans.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanScopeExample {

    @Autowired
    private PrototypeBean prototypeBean1;

    @Autowired
    private PrototypeBean prototypeBean2;

    @PostConstruct
    public void init(){
        System.out.println("Init Method Called");
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);
    }


}
