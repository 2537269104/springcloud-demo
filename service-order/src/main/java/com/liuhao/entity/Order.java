package com.liuhao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
@Data
public class Order implements Serializable {

    private Integer id;

    private String name;

    private Integer userId;

    private String username;
}
