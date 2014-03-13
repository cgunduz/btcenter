package com.cemgunduz.btcenter.services.impl;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.entity.constants.OrderType;
import com.cemgunduz.btcenter.exchanges.BitStamp;
import com.cemgunduz.btcenter.services.OrderService;
import com.cemgunduz.utils.entity.RestResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgunduz on 2/6/14.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getBitstampBuyOrderList(int amount) {

        return getBitstampOrderListByOrderType(OrderType.BID, amount);
    }

    @Override
    public List<Order> getBitstampSellOrderList(int amount) {

        return getBitstampOrderListByOrderType(OrderType.ASK, amount);
    }

    private List<Order> getBitstampOrderListByOrderType(OrderType orderType, int amount) {

        BitStamp bitStamp = new BitStamp();
        RestResponse response = bitStamp.getOrderbook();

        List<Order> recentOrderList = new ArrayList<Order>();
        List<List<Double>> nestedList = (List<List<Double>>) response.getData(orderType.getValue());

        int recordNo = 0;
        for(List<Double> subList : nestedList)
        {
            Order order = new Order();
            order.setValue(subList.get(0));
            order.setAmount(subList.get(1));
            order.setOrderType(orderType);

            recentOrderList.add(order);

            recordNo++;
            if(recordNo < amount)
                break;
        }

        return recentOrderList;
    }
}
