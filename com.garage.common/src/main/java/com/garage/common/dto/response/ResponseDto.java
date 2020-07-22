package com.garage.common.dto.response;


import lombok.Getter;
import lombok.Setter;

public class ResponseDto<T> {

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private T data;

    private ResponseDto() {

    }

    public ResponseDto data(T data) {
        this.status = 1;
        this.data = data;
        return this;
    }

    public ResponseDto error(T data) {
        this.status = 0;
        this.data = data;
        return this;
    }

    public static ResponseDto build() {
        return new ResponseDto<>();
    }

}
