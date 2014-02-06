package com.cemgunduz.btcenter.exchanges.constants;

/**
 * Created by cgunduz on 1/29/14.
 */
public enum BitstampRestApi {

    GET_TICKER("https://www.bitstamp.net/api/ticker/"),
    GET_TRANSACTIONS("https://www.bitstamp.net/api/transactions/"),
    GET_EUR_USD_CONVERSION_RATE("https://www.bitstamp.net/api/eur_usd/"),
    GET_ORDERBOOK("https://www.bitstamp.net/api/order_book/");

    private String url;

    private BitstampRestApi(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
}
