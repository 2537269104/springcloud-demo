package com.liuhao.service.impl;

import com.liuhao.entity.User;
import com.liuhao.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    public User getUserById(Integer id){

        User user = new User();

        user.setId(id);
        user.setUsername("username"+id);
        return user;
    }




    @Override
    public String getUsernameById(Integer id) {

        User user = getUserById(id);

        return user.getUsername();
    }

    @Override
    public User getUserByUser(User user) {

        User user1 = new User();user1.setId(user.getId());
        user1.setUsername("张三"+user.getId());
        return user1;
    }
}
