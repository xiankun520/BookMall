package com.example.bookmall.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.example.bookmall.Dao.BookDao"})
public class MyBatisConfig {
}
