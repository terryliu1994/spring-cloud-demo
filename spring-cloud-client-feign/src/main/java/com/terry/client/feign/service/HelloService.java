package com.terry.client.feign.service;

import com.terry.client.feign.service.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-service-provider", fallback = HelloServiceHystrix.class)
public interface HelloService {


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String hello(@RequestParam("user") String user); // @RequestParam 必须有
}
