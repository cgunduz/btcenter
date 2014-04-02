package com.cemgunduz.btcenter.job;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.entity.constants.OrderType;
import com.cemgunduz.btcenter.services.OrderHistoryService;
import com.cemgunduz.exchanges.BitStamp;
import com.cemgunduz.utils.entity.RestResponse;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgunduz on 3/27/14.
 */
@Component
@Scope(value = "prototype")
public class OrderRecorderJob implements Job {

    @Autowired
    OrderHistoryService orderHistoryService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Working");
        BitStamp bitStamp = new BitStamp();
        RestResponse response = bitStamp.getOrderbook();

        List<Order> recentOrderList = new ArrayList<Order>();

        if(!response.isSuccess())
            return;

        List<List<Double>> nestedList = (List<List<Double>>) response.getData("bids");
        long unixtimestamp = System.currentTimeMillis();
        for(List<Double> subList : nestedList)
        {
            Order order = new Order(subList.get(0), subList.get(1), OrderType.BID, unixtimestamp);
            recentOrderList.add(order);
        }

        nestedList = (List<List<Double>>) response.getData("asks");
        for(List<Double> subList : nestedList)
        {
            Order order = new Order(subList.get(0), subList.get(1), OrderType.ASK, unixtimestamp);
            recentOrderList.add(order);
        }

        orderHistoryService.addNewOrders(recentOrderList);
    }

    public static Trigger getDefaultTrigger()
    {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("OrderRecorderTrigger", "BTCENTER")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                .build();

        return trigger;
    }

    public static JobDetail getDefaultJobDetail()
    {
        return JobBuilder.newJob(OrderRecorderJob.class).withIdentity("OrderRecorderJob", "BTCENTER").build();
    }
}
