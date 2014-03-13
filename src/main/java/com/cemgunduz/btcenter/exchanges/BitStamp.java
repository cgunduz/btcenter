package com.cemgunduz.btcenter.exchanges;

import com.cemgunduz.btcenter.exchanges.constants.BitstampRestApi;
import com.cemgunduz.utils.entity.RestResponse;
import com.cemgunduz.utils.impl.WebUtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cgunduz on 1/29/14.
 */

@Component
public class BitStamp {

    @Autowired
    WebUtilsImpl webUtils;

    public RestResponse getTicker()
    {
        return webUtils.getRestResponse(BitstampRestApi.GET_TICKER.getUrl());
    }

    public RestResponse getOrderbook()
    {
        return webUtils.getRestResponse(BitstampRestApi.GET_ORDERBOOK.getUrl());
    }

    public RestResponse getTransactions()
    {
        return webUtils.getRestResponse(BitstampRestApi.GET_TRANSACTIONS.getUrl());
    }

    public RestResponse getConversionRate()
    {
        return webUtils.getRestResponse(BitstampRestApi.GET_EUR_USD_CONVERSION_RATE.getUrl());
    }
}
