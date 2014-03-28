package com.cemgunduz.btcenter.job;


import org.quartz.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
/**
 * Created by cgunduz on 2/5/14.
 */
@Component
@Scope(value = "prototype")
public class PredictionCreationJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


    }

    public static Trigger getDefaultTrigger()
    {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("PredictionCreationTrigger", "BTCENTER")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* 0/1 * * * ?"))
                .build();

        return trigger;
    }

    public static JobDetail getDefaultJobDetail()
    {
        return JobBuilder.newJob(TickerRecorderJob.class).withIdentity("PredictionCreationJob", "BTCENTER").build();
    }
}
