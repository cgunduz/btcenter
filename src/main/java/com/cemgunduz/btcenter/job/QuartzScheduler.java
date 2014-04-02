package com.cemgunduz.btcenter.job;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by cgunduz on 3/27/14.
 */

//=)
public class QuartzScheduler {

    public void start()
    {
        Scheduler scheduler = null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(TickerRecorderJob.getDefaultJobDetail(), TickerRecorderJob.getDefaultTrigger());
            scheduler.scheduleJob(OrderRecorderJob.getDefaultJobDetail(), OrderRecorderJob.getDefaultTrigger());
        } catch (SchedulerException e) {
            // TODO : Log ?
        }
    }
}
