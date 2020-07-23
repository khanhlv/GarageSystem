package com.garage.web.api.controller;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.dto.GResponse;
import com.garage.common.dto.error.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@Api(value = "/", description = "Quản lý lỗi hệ thống")
public class ErrorsController implements ErrorController {

    @GetMapping("/error")
    @AllowAnonymous
    @ApiOperation(value = "Quản lý lỗi 404, 500")
    public GResponse handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        ErrorResponse errorResponse = new ErrorResponse();

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                errorResponse.setTimestamp(new Date().getTime());
                errorResponse.setMessage("Không tim thấy API");
                errorResponse.setCode(404);
            }

            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorResponse.setTimestamp(new Date().getTime());
                errorResponse.setMessage("Có lỗi trong quá trình xử lý");
                errorResponse.setCode(500);
            }
        }

        return GResponse.build().error(errorResponse);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
