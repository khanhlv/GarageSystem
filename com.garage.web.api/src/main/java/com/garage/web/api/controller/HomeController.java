package com.garage.web.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.dto.GResponse;
import com.garage.common.security.TokenProvider;
import com.garage.web.api.dto.login.LoginRequest;
import com.garage.web.api.dto.login.LoginResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "/", description = "API")
public class HomeController {

    @Autowired
    private TokenProvider tokenProvider;

    @GetMapping("/")
    @AllowAnonymous
    @ApiOperation(value = "Trang chủ")
    public GResponse home() {
        return GResponse.build().data("OK");
    }

    @PostMapping("/login")
    @AllowAnonymous
    @ApiOperation(value = "Đăng nhập")
    public GResponse login(@RequestBody LoginRequest request) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", request.getUsername());
        claims.put("fullname", "Lại Văn Khánh");
        claims.put("email", "khanhlv@gmail.com");

        String token = tokenProvider.createToken(claims, request.getUsername());

        return GResponse.build().data(new LoginResponse(token));
    }

    @GetMapping("/logout")
    @AllowAnonymous
    @ApiOperation(value = "Đăng xuất")
    public GResponse logout() {
        return GResponse.build().data("OK");
    }
}
