package com.garage.common.dto.request;

import lombok.Getter;
import lombok.Setter;

public class RequestDto<T> {

    @Getter
    @Setter
    private T data;
}
