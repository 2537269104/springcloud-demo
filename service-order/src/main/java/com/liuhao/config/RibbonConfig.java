package com.liuhao.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    /*
    restTemplate发送请求    @LoadBalanced实现负载均衡
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    /**
     * 指定负载均衡算法
     * @return
     */
    @Bean
    public IRule iRule(){
        //随机算法
        //return  new RandomRule();
        return new RoundRobinRule();
    }
}
