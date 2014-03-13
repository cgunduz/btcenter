package com.cemgunduz.btcenter.services.impl;

import org.springframework.stereotype.Service;

/**
 * Created by cgunduz on 2/5/14.
 */

@Service
public class OrderBookInspectorServiceImpl extends AbstractOrderBookInspectorService {

    // TODO : NOT STARTED YET

    @Override
    public double getMinLowEstimation() {
        return 0;
    }

    @Override
    public double getMaxHighEstimation() {
        return 0;
    }

    @Override
    public double trendsByOrderAmount(int amount) {
        return 0;
    }

    @Override
    public double nextHourTrends() {
        return 0;
    }

    @Override
    public double predictionByUnixTime(int unixtime) {
        return 0;
    }

    @Override
    public double nextHourPrediction() {
        return 0;
    }
}
