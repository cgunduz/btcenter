package com.cemgunduz.btcenter.job;

import com.cemgunduz.btcenter.exchanges.BitStamp;
import com.cemgunduz.web.RestResponse;
import org.quartz.*;

/**
 * Created by cgunduz on 2/5/14.
 */
public class TickerRecorderJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        BitStamp bitStamp = new BitStamp();
        RestResponse response = bitStamp.getTicker();

        System.out.println(response.getData("bid"));
        System.out.println(response.getData("ask"));
    }

    public static Trigger getDefaultTrigger()
    {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("TickerRecorderTrigger", "BTCENTER")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();

        return trigger;
    }

    public static JobDetail getDefaultJobDetail()
    {
        return JobBuilder.newJob(TickerRecorderJob.class).withIdentity("TickerRecorderJob", "BTCENTER").build();
    }
}
