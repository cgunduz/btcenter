package com.cemgunduz.btcenter.services;

import com.cemgunduz.btcenter.entity.Order;

import java.util.List;

/**
 * Created by cgunduz on 3/27/14.
 */
public interface OrderHistoryService {

    public void addNewOrder(Order order);
    public void addNewOrders(List<Order> orderList);
}
