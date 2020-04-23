package com.liuhao.service.impl;

import com.liuhao.entity.Order;
import com.liuhao.mapper.OrderMapper;
import com.liuhao.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

       @Autowired
      private OrderMapper orderMapper;

    @Override
    public Order getOrderById(Integer id) {

        return orderMapper.selectOrderById(id);
    }

    @Override
    public String getOrdernameById(Integer id) {
        return null;
    }

}
