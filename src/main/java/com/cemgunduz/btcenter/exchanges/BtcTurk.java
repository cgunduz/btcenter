package com.cemgunduz.btcenter.exchanges;

import com.cemgunduz.utils.entity.RestResponse;
import org.springframework.stereotype.Component;

@Component
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
