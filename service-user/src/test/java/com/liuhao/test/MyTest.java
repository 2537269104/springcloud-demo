package com.liuhao.test;

import com.liuhao.entity.User;
import com.liuhao.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void test(){

        User userById = iUserService.getUserById(1);

        System.err.println(userById);

    }
}
