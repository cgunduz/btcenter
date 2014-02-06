package com.cemgunduz.btcenter.exchanges;

import com.cemgunduz.btcenter.exchanges.constants.BtcTurkRestApi;
import com.cemgunduz.web.RestResponse;
import com.cemgunduz.web.WebUtils;

public class BtcTurk {

    public RestResponse getTicker()
    {
        throw new UnsupportedOperationException("Not supported at the moment");
        //return WebUtils.getRestResponse(BtcTurkRestApi.GET_TICKER.getUrl());
    }

    public RestResponse getOrderbook()
    {
        throw new UnsupportedOperationException("Not supported at the moment");
        //return WebUtils.getRestResponse(BtcTurkRestApi.GET_ORDERBOOK.getUrl());
    }


}
