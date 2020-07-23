package com.garage.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.common.dto.GResponse;
import com.garage.service.GarageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/garage")
@Api(value = "/garage", description = "Quản lý gara ô tô")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @GetMapping("/list")
    @ApiOperation(value = "Danh sách gara ô tô")
    public GResponse list() {
        return GResponse.build().data(garageService.findAll());
    }

    @GetMapping("/list1")
    @ApiOperation(value = "Danh sách gara ô tô")
    public GResponse list1() {
        return GResponse.build().data("1111");
    }

}
