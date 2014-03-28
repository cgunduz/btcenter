package com.cemgunduz.exchanges;

import com.cemgunduz.btcenter.job.PredictionCreationJob;
import com.cemgunduz.btcenter.job.TickerRecorderJob;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by cgunduz on 1/21/14.
 */
public class App {

    public static void main(String[] args)
    {
        /*
        BlockChain blockChain = new BlockChain();
        BtcTurk btcTurk = new BtcTurk();
        BitStamp bitStamp = new BitStamp();

        RestResponse response1 = blockChain.getBitstampBtcValueForCurrencies();
        RestResponse response2 = bitStamp.getTicker();
        RestResponse response3 = bitStamp.getOrderbook();

        System.out.println(response1.getData("USD" , "buy"));
        System.out.println(response2.getData("bid"));
        System.out.println(response3.getData("asks"));
        */

        Scheduler scheduler = null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            //scheduler.scheduleJob(TickerRecorderJob.getDefaultJobDetail(), TickerRecorderJob.getDefaultTrigger());
            scheduler.scheduleJob(PredictionCreationJob.getDefaultJobDetail(), PredictionCreationJob.getDefaultTrigger());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
