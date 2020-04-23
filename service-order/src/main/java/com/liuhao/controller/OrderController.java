package com.liuhao.controller;

import com.liuhao.entity.Order;
import com.liuhao.entity.User;
import com.liuhao.feign.UserFeignClient;
import com.liuhao.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {


    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("getOrderById")
    @HystrixCommand(fallbackMethod = "getUserByUserFallbackMethod")
    public Order getOrderById(@RequestParam("id") Integer id){
        //方式一 使用ribbon+restTemplate 实现负载均衡 以及 服务间调用
        //根据oid查询order对象
        Order order = iOrderService.getOrderById(id);
        System.err.println("------------------------------------------------"+order);
        //根据orders对象里面的uid查询用户名
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id=" + order.getUserId(), User.class);
         //方式二  使用feign的方式
        //User user = userFeignClient.getUserById(order.getUserId());
        //实现 服务间调用对象传参
       // User user = new User();
        //user.setId(15);
        User u = userFeignClient.getUserById(order.getUserId());
        log.info("user:{}",u);
        order.setId(id);
        order.setUserId(u.getId());
        return order;
    }


    @RequestMapping("getOrdernameById")
    public String getOrderNoById(@RequestParam("id") Integer id){

        return iOrderService.getOrdernameById(id);
    }

   //getUserByIdFallbackMethod方法参数要和userFeginClient.getUserByIdr参数一致。
    public Order getUserByUserFallbackMethod(Integer id){

        Order order = iOrderService.getOrderById(id);
        order.setUsername("getUserByUserFallbackMethod");

        return order;
    }
}
