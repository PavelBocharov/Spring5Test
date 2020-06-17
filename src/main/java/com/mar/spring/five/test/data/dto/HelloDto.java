package com.mar.spring.five.test.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloDto {

    private String userName;
    private String formatDate;
    private String msg;

}
