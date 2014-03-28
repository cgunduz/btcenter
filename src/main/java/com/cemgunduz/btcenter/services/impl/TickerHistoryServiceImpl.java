package com.cemgunduz.btcenter.services.impl;

import com.cemgunduz.btcenter.dao.SequenceRepository;
import com.cemgunduz.btcenter.dao.TickerDao;
import com.cemgunduz.btcenter.dao.constants.Sequence;
import com.cemgunduz.btcenter.entity.Ticker;
import com.cemgunduz.btcenter.services.TickerHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cgunduz on 3/27/14.
 */
@Service
public class TickerHistoryServiceImpl implements TickerHistoryService{

    @Autowired
    SequenceRepository sequenceRepository;

    @Autowired
    TickerDao tickerDao;

    @Override
    public void addNewTicker(Ticker ticker) {

        if(ticker.getId() != null)
            throw new UnsupportedOperationException("Call update for existing orders");

        ticker.setId(sequenceRepository.nextSequence(Sequence.TICKER));
        tickerDao.save(ticker);
    }

    @Override
    public void addNewTickers(List<Ticker> tickerList) {

        for(Ticker ticker : tickerList)
            addNewTicker(ticker);
    }
}
