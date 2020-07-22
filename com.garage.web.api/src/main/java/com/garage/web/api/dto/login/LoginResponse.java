package com.garage.web.api.dto.login;

import lombok.Getter;
import lombok.Setter;

public class LoginResponse {

    @Getter
    @Setter
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
