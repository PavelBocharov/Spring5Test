package com.mar.spring.five.test.data.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class HelloDto implements Serializable {

    private String userName;
    private String formatDate;
    private String msg;

}
