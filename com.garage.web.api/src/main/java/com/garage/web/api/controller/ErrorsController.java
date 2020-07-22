package com.garage.web.api.controller;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.dto.error.ErrorDto;
import com.garage.common.dto.response.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@ApiIgnore
@Api(value = "/", description = "Quản lý lỗi hệ thống")
public class ErrorsController implements ErrorController {

    @GetMapping("/error")
    @AllowAnonymous
    @ApiOperation(value = "Quản lý lỗi 404, 500")
    public ResponseDto handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        ErrorDto errorDto = new ErrorDto();

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                errorDto.setTimestamp(new Date().getTime());
                errorDto.setMessage("Không tim thấy API");
                errorDto.setCode(404);
            }

            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorDto.setTimestamp(new Date().getTime());
                errorDto.setMessage("Có lỗi trong quá trình xử lý");
                errorDto.setCode(500);
            }
        }

        return ResponseDto.build().error(errorDto);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
