package com.liuhao.service;

import com.liuhao.entity.Order;

public interface IOrderService {


    Order getOrderById(Integer id);


    String getOrdernameById(Integer id);
}
