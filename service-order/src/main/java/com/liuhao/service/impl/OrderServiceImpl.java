package com.liuhao.service.impl;

import com.liuhao.entity.Order;
import com.liuhao.entity.User;
import com.liuhao.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {



    @Override
    public Order getOrderById(Integer id) {

        Order order = new Order();
        order.setId(id);
        order.setUserId(1);
        order.setOrderNo(System.currentTimeMillis()+"");
        return order;
    }

    @Override
    public String getOrdernameById(Integer id) {
        return null;
    }

}
