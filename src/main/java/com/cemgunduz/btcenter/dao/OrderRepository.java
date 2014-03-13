package com.cemgunduz.btcenter.dao;

import com.cemgunduz.btcenter.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * Created by cgunduz on 3/13/14.
 */

public interface OrderRepository extends MongoRepository<Order,Integer>{

    public List<Order> findByOrderType(String orderType);
}
