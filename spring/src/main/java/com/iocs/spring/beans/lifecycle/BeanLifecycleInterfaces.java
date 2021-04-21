package com.iocs.spring.beans.lifecycle;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class BeanLifecycleInterfaces implements InitializingBean, DisposableBean {

    private Logger logger = LoggerFactory.getLogger(BeanLifecycleInterfaces.class);

    @Override
    public void afterPropertiesSet(){
        logger.info("afterPropertiesSet");
    }

    @Override
    public void destroy(){
        logger.info("destroy");
    }
}
