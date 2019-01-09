package com.terry.client.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix // 启用熔断
@EnableHystrixDashboard // 启动熔断 仪表盘
public class ClientRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientRibbonApplication.class, args);
    }

}

