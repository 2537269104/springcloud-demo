package com.liuhao.jpa.test;


import com.liuhao.jpa.dao.UserDao;
import com.liuhao.jpa.dao.UserRepository;
import com.liuhao.jpa.entity.UserEntity;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

      @Autowired
    private UserRepository userRepository;


      @Test
    public void save(){

          UserEntity userEntity = new UserEntity();
          userEntity.setUsername("胡歌");
          userEntity.setPassword("sdaw");
          userEntity.setPhone("15916562251");
          userEntity.setCreateTime(new Date());

          UserEntity userEntity1 = new UserEntity();
          userEntity1.setUsername("李媛媛");
          userEntity1.setPassword("sdaw");
          userEntity1.setPhone("15916562251");
          userEntity1.setCreateTime(new Date());

          UserEntity userEntity2 = new UserEntity();
          userEntity2.setUsername("李寻欢");
          userEntity2.setPassword("sdaw");
          userEntity2.setPhone("15916562251");
          userEntity2.setCreateTime(new Date());
          ArrayList<UserEntity> list = new ArrayList();

          list.add(userEntity);
          list.add(userEntity1);
          list.add(userEntity2);


          userRepository.saveAll(list);
      }
    @Test
    public void query(){

        //根据id查询
        UserEntity userEntity = userRepository.findById(3).get();
        System.err.println(userEntity);
        //查询所有
        Iterable<UserEntity> all = userRepository.findAll();
        System.out.println(all);
    }
    @Test
    public void del(){
         //删除
         userRepository.deleteById(2);
    }

    @Test
    public void sort(){
          //单个字段进行排序
        Sort sort = Sort.by(Sort.Direction.DESC,"username");
        Iterable<UserEntity> all = userRepository.findAll(sort);
        System.err.println(all);
    }

    @Test
    public void sortByManyField(){
        //多个字段进行排序
        Sort.Order order = Sort.Order.asc("id");
        Sort.Order order2 = Sort.Order.asc("username");
        Sort sort = Sort.by(order,order2);
        Iterable<UserEntity> all = userRepository.findAll(sort);
        System.err.println(all);
    }

    @Test
    public void pageAndSortIng(){

          //构建分页的对象，page开始页数 从0开始
        Pageable pageable = PageRequest.of(0,3);

        Page<UserEntity> page = userRepository.findAll(pageable);

        System.out.println("总页数："+page.getTotalPages());
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("分页数据："+page.getContent());
        //排序分页
        Pageable pageable1 = PageRequest.of(0,3, Sort.Direction.DESC,"id");
        Page<UserEntity> page1 = userRepository.findAll(pageable1);
        System.err.println("总页数："+page1.getTotalPages());
        System.err.println("总条数："+page1.getTotalElements());
        System.err.println("分页数据："+page1.getContent());
    }



    @Test
    public void findByUsernameLikeOrderByIdDesc(){


        List<UserEntity> byUsernameOrderByIdDesc = userRepository.findByUsernameLikeOrderByIdDesc("%李%");
        System.err.println(byUsernameOrderByIdDesc);
    }


    @Test
    public void findByUsername(){

        Pageable pageRequest = PageRequest.of(0, 3);
        Page<UserEntity> byUsernameLike = userRepository.findByUsername("李寻欢", pageRequest);
        System.err.println(byUsernameLike.getTotalElements());
        System.err.println(byUsernameLike.getTotalPages());
        System.err.println(byUsernameLike.getContent());
    }

    @Test
    public void findByUsernameLike(){

        Pageable pageRequest = PageRequest.of(0, 3);
        Page<UserEntity> byUsernameLike = userRepository.findByUsernameLike("%李%", pageRequest);
        System.err.println(byUsernameLike.getTotalElements());
        System.err.println(byUsernameLike.getTotalPages());
        System.err.println(byUsernameLike.getContent());
    }

    @Test
    public void findOrderByUsername(){


        List<UserEntity> byUsername = userRepository.findByUsername("李寻欢",Sort.by(Sort.Direction.DESC,"id"));

        System.err.println(byUsername);
    }
}




