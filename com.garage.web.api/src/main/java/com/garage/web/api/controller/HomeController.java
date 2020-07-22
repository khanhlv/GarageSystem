package com.garage.web.api.controller;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.dto.response.ResponseDto;
import com.garage.utils.JwtTokenUtil;
import com.garage.web.api.dto.login.LoginRequest;
import com.garage.web.api.dto.login.LoginResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Api(value = "/", description = "API")
public class HomeController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/")
    @AllowAnonymous
    @ApiOperation(value = "Trang chủ")
    public ResponseDto home() {
        return ResponseDto.build().data("OK");
    }

    @PostMapping("/login")
    @AllowAnonymous
    @ApiOperation(value = "Đăng nhập")
    public ResponseDto login(@RequestBody LoginRequest request) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", request.getUsername());
        claims.put("fullname", "Lại Văn Khánh");
        claims.put("email", "khanhlv@gmail.com");

        String token = jwtTokenUtil.createToken(claims, request.getUsername());

        return ResponseDto.build().data(new LoginResponse(token));
    }

    @GetMapping("/logout")
    @AllowAnonymous
    @ApiOperation(value = "Đăng xuất")
    public ResponseDto logout() {
        return ResponseDto.build().data("OK");
    }
}
