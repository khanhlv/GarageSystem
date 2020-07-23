package com.garage.common.dto;

import lombok.Getter;
import lombok.Setter;

public class GRequest<T> {

    @Getter
    @Setter
    private T data;

    private GRequest() {

    }

    public GRequest data(T data) {
        this.data = data;
        return this;
    }

    public static GRequest build() {
        return new GRequest<>();
    }
}