package com.hjb.bangbangserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@MapperScan("com.hjb.bangbangserver.mapper")
@EnableCaching
public class BangbangStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BangbangStoreApplication.class, args);
    }



}
