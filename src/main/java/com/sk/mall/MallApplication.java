package com.sk.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sk.mall.dao")
@SpringBootApplication
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
