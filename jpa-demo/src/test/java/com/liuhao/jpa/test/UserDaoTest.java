package com.liuhao.jpa.test;


import com.liuhao.jpa.dao.UserDao;
import com.liuhao.jpa.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

      @Autowired
    private UserDao userDao;


      @Test
    public void save(){

          UserEntity userEntity = new UserEntity();
          userEntity.setId(2);
          userEntity.setUsername("李四44444444444");
          userEntity.setPassword("456144444411");
          userEntity.setPhone("15922224444444496251");
          userEntity.setCreateTime(new Date());
          userDao.save(userEntity);

      }
    @Test
    public void delete(){

           //如果删除的对象不存在 会有异常
           userDao.deleteById(1);


    }

    @Test
    public void findById(){

        UserEntity userEntity = userDao.findById(2);

            System.err.println(userEntity);
    }

    @Test
    public void find(){

        List<UserEntity> all = userDao.findAll();
        System.err.println(all);
        List<UserEntity> list = userDao.findByUsername("三");

        for(int i=0;i<list.size();i++){
            System.err.println(list.get(i));
        }
    }
}




