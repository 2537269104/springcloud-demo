package com.liuhao.service.impl;

import com.liuhao.entity.User;
import com.liuhao.mapper.UserMapper;
import com.liuhao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    public User getUserById(Integer id){

        return userMapper.getUserById(id);
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
