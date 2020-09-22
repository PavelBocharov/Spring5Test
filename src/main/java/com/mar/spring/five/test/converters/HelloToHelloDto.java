package com.mar.spring.five.test.converters;

import com.mar.spring.five.test.data.dto.HelloDto;
import com.mar.spring.five.test.data.entity.Hello;
import com.mar.spring.five.test.data.validator.HelloValidator;
import com.mar.spring.five.test.data.validator.handler.AbstractValidationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HelloToHelloDto implements Converter<Hello, HelloDto> {

    @Autowired
    private AbstractValidationHandler<Hello, HelloValidator> helloValidator;

    @Override
    public HelloDto convert(Hello source) {
        helloValidator.isValid(source);
        return HelloDto.builder()
                .userName(source.getUserName())
                .formatDate(source.getSendDate().toString())
                .msg(source.getMsg())
                .build();
    }

}
