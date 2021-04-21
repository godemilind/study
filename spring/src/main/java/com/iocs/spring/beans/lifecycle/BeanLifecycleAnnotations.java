package com.iocs.spring.beans.lifecycle;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@RequestScope
/*
To test Bean lifecycle methods
Scope is kept request so that lifecycle methods can be observed
 */
public class BeanLifecycleAnnotations {

    @PostConstruct
    public void init(){
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pre Destroy");
    }
}
