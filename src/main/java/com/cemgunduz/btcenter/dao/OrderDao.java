package com.cemgunduz.btcenter.dao;

import com.cemgunduz.btcenter.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * Created by cgunduz on 3/13/14.
 */

public interface OrderDao extends MongoRepository<Order,Long>{

    public List<Order> findByOrderType(String orderType);
    public List<Order> findByValue(Double value);
}
