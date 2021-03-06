package com.example.mongo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mongo.mapper")
public class MongoApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(MongoApplication.class, args);
    }

}
