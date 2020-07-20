package com.garage.common.dto.response;


import java.util.Date;

import com.garage.common.dto.error.ErrorDto;
import lombok.Getter;
import lombok.Setter;

public class ResponseDto<T> {

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private T data;

    public ResponseDto withData(T data) {
        this.status = 1;
        this.data = data;
        return this;
    }

    public ResponseDto withError(T data) {
        this.status = 0;
        this.data = data;
        return this;
    }

    public static ResponseDto build() {
        return new ResponseDto<>();
    }

}
