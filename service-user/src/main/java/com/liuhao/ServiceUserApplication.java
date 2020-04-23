package com.liuhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.liuhao.mapper")
public class ServiceUserApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceUserApplication.class,args);
    }

}
