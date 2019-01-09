package com.terry.client.ribbon.servie;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(String user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);

        return restTemplate.getForObject("http://SPRING-CLOUD-SERVICE-PROVIDER/hello?user={user}", String.class, map);
    }

    public String hiError(String user) {
        return String.format("Sorry %s ,your request error", user);
    }
}
