package com.example.dubbo.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 年龄
     */
    private Integer age;

    private static final long serialVersionUID = 1L;
}