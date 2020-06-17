package com.mar.spring.five.test.api;

import com.mar.spring.five.test.data.dto.HelloDto;
import com.mar.spring.five.test.data.entity.Hello;
import com.mar.spring.five.test.service.HelloService;
import com.mar.spring.five.test.service.logs.LogMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Controller {

    private Logger log = Logger.getLogger(Controller.class.getSimpleName());

    @Autowired
    private HelloService helloService;

    @Autowired
    private ConversionService conversionService;

    @GetMapping("info")
    @LogMethod
    public HelloDto info(@RequestParam(value = "login", required = false) String login) {
        Hello hello = helloService.hello(login);
        String response = hello.getMsg() + " Now date time - " + hello.getSendDate().toString();
        return conversionService.convert(hello, HelloDto.class);
    }

}
