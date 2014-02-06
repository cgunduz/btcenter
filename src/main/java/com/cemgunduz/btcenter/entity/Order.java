package com.cemgunduz.btcenter.entity;

import com.cemgunduz.btcenter.entity.constants.OrderType;

/**
 * Created by cgunduz on 2/5/14.
 */
public class Order {

    private Double value;
    private Double amount;
    private OrderType orderType;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Value : " + value + "\nAmount : " + amount + "\nOrderType + " + orderType.getValue();
    }
}
