package com.liuhao.config;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@JsonIgnoreProperties("$$beanFactory")
//配置类
@Configuration
@ConfigurationProperties(prefix = "config")
public class ConsulConfigInfo {


    private String name;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
