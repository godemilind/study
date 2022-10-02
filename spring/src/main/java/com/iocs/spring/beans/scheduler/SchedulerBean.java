package com.iocs.spring.beans.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerBean {

    /*  fixedRate : makes Spring run the task on periodic intervals even if the last invocation may still be running.
        fixedDelay : specifically controls the next execution time when the last execution finishes. */

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
