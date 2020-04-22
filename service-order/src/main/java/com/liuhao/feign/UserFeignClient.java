package com.liuhao.feign;

import com.liuhao.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * service-user 指定的服务名称
 */
@Component
@FeignClient(name = "service-user",fallback = UserFeignFallback.class)
public interface UserFeignClient {


    @RequestMapping("/user/getUserById")
    public User getUserById(@RequestParam("id") Integer id);


    @RequestMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserByUser")
    public User getUserByUser(@RequestBody User user);
}
