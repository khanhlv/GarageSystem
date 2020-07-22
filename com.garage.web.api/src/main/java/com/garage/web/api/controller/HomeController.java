package com.garage.web.api.controller;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.dto.response.ResponseDto;
import com.garage.model.Garage;
import com.garage.service.GarageJDBCRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "/", description = "API Test")
public class HomeController {


    @Autowired
    private GarageJDBCRepository garageJDBCRepository;

    @GetMapping("/")
    @AllowAnonymous
    @ApiOperation(value = "Test API Home")
    public ResponseEntity home() {
        return ResponseEntity.ok("1");
    }


    @GetMapping("/test")
    @AllowAnonymous
    @ApiOperation(value = "Test API Home")
    public ResponseDto test() {
        return ResponseDto.build().withData(garageJDBCRepository.findAll());
    }

}
