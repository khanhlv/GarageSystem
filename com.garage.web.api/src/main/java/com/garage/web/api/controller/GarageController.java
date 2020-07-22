package com.garage.web.api.controller;

import com.garage.common.dto.response.ResponseDto;
import com.garage.service.GarageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/garage")
@Api(value = "/garage", description = "Quản lý gara ô tô")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @GetMapping("/list")
    @ApiOperation(value = "Danh sách gara ô tô")
    public ResponseDto list() {
        return ResponseDto.build().data(garageService.findAll());
    }

    @GetMapping("/list1")
    @ApiOperation(value = "Danh sách gara ô tô")
    public ResponseDto list1() {
        return ResponseDto.build().data("1111");
    }

}
