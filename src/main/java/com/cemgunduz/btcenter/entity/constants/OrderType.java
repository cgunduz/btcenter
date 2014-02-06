package com.cemgunduz.btcenter.entity.constants;

/**
 * Created by cgunduz on 2/5/14.
 */
public enum OrderType {

    ASK("Asks"),BID("Bids");

    private String value;

    private OrderType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
