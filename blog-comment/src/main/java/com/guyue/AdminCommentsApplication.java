package com.guyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tokyo
 * @date 2022/1/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.guyue.mapper.*")
public class AdminCommentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminCommentsApplication.class,args);
    }
}
