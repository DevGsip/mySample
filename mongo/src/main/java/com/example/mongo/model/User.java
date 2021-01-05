package com.example.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
@Document(collection = "user_collection")
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