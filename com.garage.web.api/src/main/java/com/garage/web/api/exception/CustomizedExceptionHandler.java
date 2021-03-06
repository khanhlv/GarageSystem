package com.garage.web.api.exception;

import com.garage.common.dto.GResponse;
import com.garage.common.dto.error.ErrorResponse;
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
    public final GResponse handleException(AuthorizationException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date().getTime());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setCode(ex.getCode());

        return GResponse.build().error(errorResponse);
    }

    @ExceptionHandler(SystemException.class)
    public final GResponse handleException(SystemException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date().getTime());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setCode(99);

        return GResponse.build().error(errorResponse);
    }

}
