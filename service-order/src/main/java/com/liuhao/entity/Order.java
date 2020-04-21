package com.liuhao.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Order implements Serializable {

    private Integer id;

    private String orderNo;

    private Integer userId;

    private String username;
}
