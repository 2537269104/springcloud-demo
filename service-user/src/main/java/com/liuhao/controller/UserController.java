package com.liuhao.controller;

import com.liuhao.entity.User;
import com.liuhao.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id") Integer id){
       log.info("userid:{}",id);
        return iUserService.getUserById(id);
    }

    @RequestMapping("getUserByUser")
    public User getUserByUser(@RequestBody User user){

        log.info("userid:{}",user);
        return iUserService.getUserByUser(user);
    }

}
