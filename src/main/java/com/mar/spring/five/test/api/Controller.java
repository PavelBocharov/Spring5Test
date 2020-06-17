package com.mar.spring.five.test.api;

import com.mar.spring.five.test.service.HelloService;
import com.mar.spring.five.test.service.logs.LogMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.logging.Logger;

@RestController
public class Controller {

    private Logger log = Logger.getLogger(Controller.class.getSimpleName());

    @Autowired
    private HelloService helloService;

    @GetMapping("info")
    @LogMethod
    public String info(
            @RequestParam(value = "login", required = false) String login
    ) {
        String response = helloService.hello(login) + " Now date time - " + OffsetDateTime.now().toString();
        log.info(response);
        return response;
    }

}
