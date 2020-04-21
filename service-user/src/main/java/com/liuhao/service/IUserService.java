package com.liuhao.service;

import com.liuhao.entity.User;

public interface IUserService {


    //根据id查询用户
    User getUserById(Integer id);


    //根据id查询用户名
    String getUsernameById(Integer id);

    User getUserByUser(User user);
}
