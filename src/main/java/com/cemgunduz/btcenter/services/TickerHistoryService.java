package com.cemgunduz.btcenter.services;

import com.cemgunduz.btcenter.entity.Ticker;

import java.util.List;

/**
 * Created by cgunduz on 3/27/14.
 */
public interface TickerHistoryService {

    public void addNewTicker(Ticker ticker);
    public void addNewTickers(List<Ticker> tickerList);
}
