package com.mar.spring.five.test.converters;

import com.mar.spring.five.test.data.dto.HelloDto;
import com.mar.spring.five.test.data.entity.Hello;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HelloToHelloDto implements Converter<Hello, HelloDto> {

    @Override
    public HelloDto convert(Hello source) {
        return HelloDto.builder()
                .userName(source.getUserName())
                .formatDate(source.getSendDate().toString())
                .msg(source.getMsg())
                .build();
    }

}
