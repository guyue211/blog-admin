package com.guyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tokyo
 * @date 2022/1/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdminLabelApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminLabelApplication.class,args);
    }
}

