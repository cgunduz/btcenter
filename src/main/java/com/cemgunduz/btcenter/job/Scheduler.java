package com.cemgunduz.btcenter.job;

import com.cemgunduz.btcenter.entity.Ticker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by cgunduz on 3/27/14.
 */
@Component
public class Scheduler {

    @Autowired
    PredictionCreationJob predictionCreationJob;

    @Autowired
    TickerRecorderJob tickerRecorderJob;

    @PostConstruct
    public void start()
    {

    }
}
