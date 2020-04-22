package com.liuhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

//feign注解
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class ServiceOrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceOrderApplication.class,args);
    }

}
