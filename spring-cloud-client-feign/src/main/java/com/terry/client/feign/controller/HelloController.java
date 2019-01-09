package com.terry.client.feign.controller;

import com.terry.client.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String user) {
        return helloService.hello(user);
    }

}
