package com.yi5an.orderservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.yi5an.orderservicedemo.openfeign"})
public class OrderServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceDemoApplication.class, args);
    }

}
