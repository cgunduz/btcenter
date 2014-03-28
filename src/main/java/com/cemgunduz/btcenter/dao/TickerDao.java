package com.cemgunduz.btcenter.dao;

import com.cemgunduz.btcenter.entity.Ticker;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cgunduz on 3/27/14.
 */
public interface TickerDao extends MongoRepository<Ticker,Long> {


}
