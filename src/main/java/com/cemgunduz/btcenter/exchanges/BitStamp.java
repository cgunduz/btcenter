package com.cemgunduz.btcenter.exchanges;

import com.cemgunduz.btcenter.exchanges.constants.BitstampRestApi;
import com.cemgunduz.web.RestResponse;
import com.cemgunduz.web.WebUtils;

/**
 * Created by cgunduz on 1/29/14.
 */
public class BitStamp {

    public RestResponse getTicker()
    {
        return WebUtils.getRestResponse(BitstampRestApi.GET_TICKER.getUrl());
    }

    public RestResponse getOrderbook()
    {
        return WebUtils.getRestResponse(BitstampRestApi.GET_ORDERBOOK.getUrl());
    }

    public RestResponse getTransactions()
    {
        return WebUtils.getRestResponse(BitstampRestApi.GET_TRANSACTIONS.getUrl());
    }

    public RestResponse getConversionRate()
    {
        return WebUtils.getRestResponse(BitstampRestApi.GET_EUR_USD_CONVERSION_RATE.getUrl());
    }
}
