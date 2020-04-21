package com.liuhao.service;

import com.liuhao.entity.Order;
import com.liuhao.entity.User;

public interface IOrderService {





    Order getOrderById(Integer id);


    String getOrdernameById(Integer id);
}
