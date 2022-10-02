package com.iocs.spring.beans.lifecycle;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifecycleInterfaces implements InitializingBean, DisposableBean, BeanPostProcessor, BeanNameAware, BeanFactoryAware, ApplicationContextAware{

    private Logger logger = LoggerFactory.getLogger(BeanLifecycleInterfaces.class);

    public BeanLifecycleInterfaces(){
        logger.info("Constructor Called");
    }

    @Override
    public void afterPropertiesSet(){
        logger.info("InitializingBean afterPropertiesSet");
    }

    @Override
    public void destroy(){
        logger.info(" DisposableBean destroy");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info(beanName+ "postProcessBeforeInitialization");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessAfterInitialization");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public void setBeanName(String s) {
        logger.info("setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("setApplicationContext");
    }

    @PostConstruct
    public void customInitMethod(){
        logger.info("@PostConstruct custom init");
    }

    @PreDestroy
    public void customDestroyMethod(){
        logger.info("@PreDestroy custom destroy");
    }


}
