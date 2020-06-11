package com.example.demo.conf;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${defaultUser.login}")
    private String defaultUserLogin;

    @Bean
    public HelloService helloService() {
        return new HelloService(defaultUserLogin);
    }

}
