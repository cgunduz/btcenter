package com.cemgunduz.btcenter.job;

import com.cemgunduz.btcenter.entity.Ticker;
import com.cemgunduz.btcenter.services.TickerHistoryService;
import com.cemgunduz.exchanges.BitStamp;
import com.cemgunduz.utils.entity.RestResponse;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by cgunduz on 2/5/14.
 */
@Component
@Scope(value = "prototype")
public class TickerRecorderJob implements Job {

    @Autowired
    TickerHistoryService tickerHistoryService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        BitStamp bitStamp = new BitStamp();
        RestResponse response = bitStamp.getTicker();

        Ticker ticker = new Ticker();
        ticker.setAsk((Double)response.getData("ask"));
        ticker.setBid((Double) response.getData("bid"));
        ticker.setHigh((Double)response.getData("high"));
        ticker.setLow((Double) response.getData("low"));
        ticker.setLast((Double) response.getData("last"));
        ticker.setVwap((Double) response.getData("vwap"));
        ticker.setVolume((Double) response.getData("volume"));
        ticker.setTimestamp(System.currentTimeMillis());

        tickerHistoryService.addNewTicker(ticker);
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
