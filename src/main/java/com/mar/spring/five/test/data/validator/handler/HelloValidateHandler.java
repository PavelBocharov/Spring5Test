package com.mar.spring.five.test.data.validator.handler;

import com.mar.spring.five.test.data.entity.Hello;
import com.mar.spring.five.test.data.validator.HelloValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloValidateHandler extends AbstractValidationHandler<Hello, HelloValidator> {

    @Autowired
    public HelloValidateHandler(HelloValidator helloValidator) {
        super(Hello.class, helloValidator);
    }
}
