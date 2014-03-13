package com.cemgunduz.btcenter.services;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.services.constants.PanicLevel;

import java.util.List;

/**
 * Created by cgunduz on 2/5/14.
 */
public interface OrderBookInspectorService {

    // Returns first wall
    double getFirstBuyWall();
    double getFirstSellWall();

    // Returns the estimation of global min/max for the day
    double getMinLowEstimation();
    double getMaxHighEstimation();

    // Returns the total amount of buy vs sell requests for a given amount of requests
    double trendsByOrderAmount(int amount);
    double nextHourTrends();

    // Returns the predictionary value of a single btc for the defined time
    double predictionByUnixTime(int unixtime);
    double nextHourPrediction();

    // Predicts the panic level by Orderbook values
    PanicLevel detectSuddenBuyOrders();
    PanicLevel detectSuddenSellOrders();

}
