package com.cemgunduz.btcenter.entity;

import com.cemgunduz.btcenter.entity.constants.OrderType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by cgunduz on 2/5/14.
 */
@Document(collection = "Order")
public class Order {

    public Order(){}

    public Order(Double value, Double amount, OrderType orderType, Long unixTimestamp) {
        this.value = value;
        this.amount = amount;
        this.orderType = orderType;
        this.unixTimestamp = unixTimestamp;
    }

    @Id
    private int id;

    private Double value;
    private Double amount;

    @Indexed
    private OrderType orderType;

    @Indexed
    private Long unixTimestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Long getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(Long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    @Override
    public String toString() {
        return "Value : " + value + "\nAmount : " + amount + "\nOrderType : " + orderType.getValue()
                + "\nTimestamp : " + unixTimestamp;
    }
}
