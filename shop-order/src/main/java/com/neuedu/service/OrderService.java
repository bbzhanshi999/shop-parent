package com.neuedu.service;

import com.neuedu.bean.Order;
import com.neuedu.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public void save(Order order) {
        orderDao.save(order);
    }
}
