package com.coder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.atguigu.shardingjdbcdemo.mapper")
@SpringBootApplication
public class ShardingJdbcApplication {

    public static void main(String[] args) {
        // System.out.println("麦子".length());
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }

}
