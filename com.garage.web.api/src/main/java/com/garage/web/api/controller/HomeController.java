package com.garage.web.api.controller;

import com.garage.common.anotation.AllowAnonymous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "/", description = "API Test")
public class HomeController {

    @GetMapping("/")
    @AllowAnonymous
    @ApiOperation(value = "Test API Home")
    public ResponseEntity home() {
        return ResponseEntity.ok("1");
    }
}
