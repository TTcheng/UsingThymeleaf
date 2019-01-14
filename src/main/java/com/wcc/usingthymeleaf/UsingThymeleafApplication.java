package com.wcc.usingthymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wcc.*.mapper")
@SpringBootApplication
public class UsingThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsingThymeleafApplication.class, args);
    }

}

