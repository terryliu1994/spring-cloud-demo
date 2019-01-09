package com.terry.client.feign.service.hystrix;

import com.terry.client.feign.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {

    @Override
    public String hello(String user) {
        return String.format("Sorry %s ,your request error", user);
    }
}
