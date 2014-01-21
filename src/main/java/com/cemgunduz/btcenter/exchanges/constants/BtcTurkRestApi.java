package com.cemgunduz.btcenter.exchanges.constants;

/**
 * Created by cgunduz on 1/21/14.
 */
public enum BtcTurkRestApi {

    GET_TICKER("https://www.btcturk.com/api/ticker"),
    GET_ORDERBOOK("https://www.btcturk.com/api/orderbook");

    private String url;

    private BtcTurkRestApi(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
}
