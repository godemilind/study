package com.iocs.spring.beans.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerBean {

    @Scheduled(fixedRate = 60000)
    public void fixedRateScheduler(){
        System.out.println("Fix Rate Scheduler Running");
    }

    @Scheduled(fixedDelay = 60000)
    public void fixedDelayScheduler(){
        System.out.println("Fix Delay Scheduler Running");
    }

    @Scheduled(cron="*/55 * * * * ?")
    public void cronScheduler(){
        System.out.println("Cron Scheduler Running");
    }
}
