package com.liuhao.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//定义为数据库表映射的实体关系
//如果数据库表和实体类不一致，需要table注解，指定表名
@Entity
@Table(name = "t_user")
@Data
public class UserEntity {

    /**
     * 主键的生成策略 AUTO IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //没有被注解的属性，在建表时也会生成对应的字段
    private String username;
    private String password;

    private String phone;
    //按照java的命名规范，在表里生成字段create_time
    private Date createTime;
}
