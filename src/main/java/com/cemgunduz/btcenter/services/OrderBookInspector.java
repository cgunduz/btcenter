package com.cemgunduz.btcenter.services;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.services.constants.PanicLevel;

import java.util.List;

/**
 * Created by cgunduz on 2/5/14.
 */
public interface OrderBookInspector {

    // Returns first buy wall
    double getFirstBuyWall(List<Order> orderBook);

    // Returns first sell wall
    double getFirstSellWall(List<Order> orderBook);

    // Returns the total amount of buy vs sell requests for a given amount of requests
    double trendsByOrderAmount(List<Order> orderBook, int amount);
    double nextHourTrends(List<Order> orderBook);

    // Returns the predictionary value of a single btc for the defined time
    double predictionByUnixTime(List<Order> orderBook, int unixtime);
    double nextHourPrediction(List<Order> orderBook);

    // Predicts the panic level by Orderbook values
    PanicLevel detectSuddenBuyOrders(List<Order> orderBook);
    PanicLevel detectSuddenSellOrders(List<Order> orderBook);




}
