package com.mar.spring.five.test.service;

import com.mar.spring.five.test.data.entity.Hello;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;

public class HelloService {

    private String defaultName;

    public HelloService(String defaultName) {
        this.defaultName = defaultName;
    }

    public Hello hello(String name) {
        Hello hello = new Hello();

        hello.setUserName(name);
        hello.setMsg(String.format("Hello, %s!", StringUtils.isEmpty(name) ? defaultName : name));
        hello.setSendDate(OffsetDateTime.now());

        return hello;
    }

}
