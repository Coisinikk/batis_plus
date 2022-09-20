package com.zjy.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.zjy.plus.mapper")
@SpringBootApplication
public class PlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class, args);
    }

}
