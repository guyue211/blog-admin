package com.guyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdminFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminFrontApplication.class,args);
    }
}
