package com.jzj.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// 组合注解，内置了
// @SpringBootApplication --> springboot application
// @EnableDiscoveryClient --> 启动eureka client
// @EnableCircuitBreaker --> Hystrix中的一个注解，由于是一个网关服务，需要启动一个断路器
// 这三个注解
@SpringCloudApplication
// 标示当前应用是Zuul Server
// 与@EnableZuulServer的区别？
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
