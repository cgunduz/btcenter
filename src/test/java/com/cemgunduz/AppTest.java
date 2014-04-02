package com.cemgunduz;

import com.cemgunduz.btcenter.dao.OrderDao;
import com.cemgunduz.btcenter.dao.SequenceRepository;
import com.cemgunduz.btcenter.dao.constants.Sequence;
import com.cemgunduz.btcenter.entity.Order;
import com.cemgunduz.btcenter.entity.constants.OrderType;
import com.cemgunduz.btcenter.services.OrderBookInspectorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/spring-config.xml"})
public class AppTest 
{
    @Autowired
    OrderBookInspectorService orderBookInspectorService;

    @Autowired
    @SuppressWarnings(value = "all")
    OrderDao orderDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private SequenceRepository sequenceRepository;

    @Test
    public void testApp()
    {
        orderBookInspectorService.getMinLowEstimation();
        Order order1 = new Order(3.0,5.0, OrderType.ASK, 1234L);
        Order order2 = new Order(2.0,5.5, OrderType.BID, 1234L);

        order1.setId(sequenceRepository.nextSequence(Sequence.ORDER));
        order2.setId(sequenceRepository.nextSequence(Sequence.ORDER));

        mongoTemplate.dropCollection("Order");

        orderDao.save(order1);
        orderDao.save(order2);

        System.out.println(order1.getId());
        System.out.println(order2.getId());

        List<Order> orderList = orderDao.findAll();

        for(Order o : orderList)
            System.out.println(o.toString());


    }
}
