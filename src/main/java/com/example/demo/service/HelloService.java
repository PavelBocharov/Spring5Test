package com.example.demo.service;

import org.springframework.util.StringUtils;

public class HelloService {

    private String defaultName;

    public HelloService(String defaultName) {
        this.defaultName = defaultName;
    }

    public String hello(String name) {
        return String.format("Hello, %s!", StringUtils.isEmpty(name) ? defaultName : name);
    }

}
