package com.cemgunduz.btcenter.exchanges;

import com.cemgunduz.btcenter.exchanges.constants.BtcTurkRestApi;
import com.cemgunduz.web.RestResponse;
import com.cemgunduz.web.WebUtils;

public class BtcTurk {

    public RestResponse getTicker()
    {
        return WebUtils.getRestResponse(BtcTurkRestApi.GET_TICKER.getUrl());
    }

    public RestResponse getOrderbook()
    {
        return WebUtils.getRestResponse(BtcTurkRestApi.GET_ORDERBOOK.getUrl());
    }
}
