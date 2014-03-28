package com.cemgunduz.btcenter.services.impl;

import com.cemgunduz.btcenter.dao.OrderDao;
import com.cemgunduz.btcenter.dao.SequenceRepository;
import com.cemgunduz.btcenter.dao.constants.Sequence;
import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cgunduz on 3/27/14.
 */
@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    SequenceRepository sequenceRepository;

    @Override
    public void addNewOrders(List<Order> orderList) {

        for(Order order : orderList)
        {
            addNewOrder(order);
        }
    }

    @Override
    public void addNewOrder(Order order) {

        if(order.getId() != null)
            throw new UnsupportedOperationException("Call update for existing orders");

        order.setId(sequenceRepository.nextSequence(Sequence.ORDER));
        orderDao.save(order);
    }
}
