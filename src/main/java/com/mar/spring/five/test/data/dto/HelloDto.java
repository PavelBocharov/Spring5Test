package com.mar.spring.five.test.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
public class HelloDto implements Serializable {

    @Schema(description = "User login")
    private String userName;

    @Schema(description = "Date now in ISO 8601")
    private OffsetDateTime formatDate;

    @Schema(description = "всякий хлам")
    private String msg;

}
