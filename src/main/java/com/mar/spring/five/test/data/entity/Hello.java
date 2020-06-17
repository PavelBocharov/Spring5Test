package com.mar.spring.five.test.data.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Hello {

    private String userName;
    private OffsetDateTime sendDate;
    private String msg;

}
