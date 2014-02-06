package com.cemgunduz.btcenter.services;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.entity.constants.OrderType;

import java.util.List;

/**
 * Created by cgunduz on 2/6/14.
 */
public interface OrderService {

    List<Order> getBitstampBuyOrderList(int amount);
    List<Order> getBitstampSellOrderList(int amount);
}
