package com.cemgunduz.btcenter.job;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.entity.constants.OrderType;
import com.cemgunduz.btcenter.exchanges.BitStamp;
import com.cemgunduz.web.RestResponse;
import org.quartz.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgunduz on 2/5/14.
 */
public class PredictionCreationJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        BitStamp bitStamp = new BitStamp();
        RestResponse response = bitStamp.getOrderbook();

        List<Order> recentOrderList = new ArrayList<Order>();

        if(!response.isSuccess())
            return;

        List<List<Double>> nestedList = (List<List<Double>>) response.getData("bids");
        for(List<Double> subList : nestedList)
        {
            Order order = new Order();
            order.setValue(subList.get(0));
            order.setAmount(subList.get(1));
            order.setOrderType(OrderType.BID);

            recentOrderList.add(order);
            // PERSIST ORDER HERE
        }


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
