package com.garage.common.dto.error;

import lombok.Getter;
import lombok.Setter;

public class ErrorDto {

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private long timestamp;

    @Getter
    @Setter
    private String message;
}
