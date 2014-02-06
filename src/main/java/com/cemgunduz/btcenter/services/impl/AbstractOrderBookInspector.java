package com.cemgunduz.btcenter.services.impl;

import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.entity.constants.OrderType;
import com.cemgunduz.btcenter.exchanges.BitStamp;
import com.cemgunduz.btcenter.services.OrderBookInspector;
import com.cemgunduz.btcenter.services.OrderService;
import com.cemgunduz.btcenter.services.constants.BtcenterServiceSettings;
import com.cemgunduz.btcenter.services.constants.PanicLevel;
import com.cemgunduz.web.RestResponse;

import java.util.List;

/**
 * Created by cgunduz on 2/5/14.
 */
public abstract class AbstractOrderBookInspector implements OrderBookInspector {

    BitStamp bitStamp = new BitStamp();
    OrderService orderService = new OrderServiceImpl();

    @Override
    public double getFirstBuyWall() {

        List<Order> orderBook = getBuyOrderBook();
        return getFirstWall(orderBook);
    }

    @Override
    public double getFirstSellWall() {

        List<Order> orderBook = getSellOrderBook();
        return getFirstWall(orderBook);
    }

    private double getFirstWall(List<Order> orderBook)
    {
        double minWall = getWallQualifier();
        for(Order order : orderBook)
            if(order.getAmount() > minWall)
                return order.getValue();

        return 0;
    }

    @Override
    public PanicLevel detectSuddenBuyOrders() {

        // TODO : REQUIRES PERSISTED VALUES
        return null;
    }

    @Override
    public PanicLevel detectSuddenSellOrders() {

        // TODO : REQUIRES PERSISTED VALUES
        return null;
    }

    // CACHE HERE LONG TTL
    protected double getWallQualifier()
    {
        RestResponse response = bitStamp.getTicker();
        Double volume = (Double)response.getData("volume");
        return volume * BtcenterServiceSettings.WALL_QUALIFIER_RATIO;
    }

    // CACHE HERE SHORT-MEDIUM TTL
    protected List<Order> getBuyOrderBook()
    {
        return orderService.getBitstampBuyOrderList(BtcenterServiceSettings.DEFAULT_ORDERBOOK_DEPTH);
    }

    // CACHE HERE SHORT-MEDIUM TTL
    protected List<Order> getSellOrderBook()
    {
        return orderService.getBitstampSellOrderList(BtcenterServiceSettings.DEFAULT_ORDERBOOK_DEPTH);
    }
}
