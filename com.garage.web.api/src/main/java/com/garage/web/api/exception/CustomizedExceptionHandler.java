package com.garage.web.api.exception;

import com.garage.common.dto.error.ErrorDto;
import com.garage.common.dto.response.ResponseDto;
import com.garage.common.exception.AuthorizationException;
import com.garage.common.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public final ResponseDto handleException(AuthorizationException ex, WebRequest request) {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setTimestamp(new Date().getTime());
        errorDto.setMessage(ex.getMessage());
        errorDto.setCode(ex.getCode());

        return ResponseDto.build().error(errorDto);
    }

    @ExceptionHandler(SystemException.class)
    public final ResponseDto handleException(SystemException ex, WebRequest request) {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setTimestamp(new Date().getTime());
        errorDto.setMessage(ex.getMessage());
        errorDto.setCode(99);

        return ResponseDto.build().error(errorDto);
    }

}
