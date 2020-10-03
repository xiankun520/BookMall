package com.example.bookmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan(basePackages = "com.example.bookmall.Dao.BookDao")
@SpringBootApplication
public class BookMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMallApplication.class, args);
    }

}
