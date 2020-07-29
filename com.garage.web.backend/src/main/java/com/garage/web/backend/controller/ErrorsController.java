package com.garage.web.backend.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.garage.common.anotation.AllowAnonymous;

@Controller
public class ErrorsController implements ErrorController {

    @GetMapping("/error")
    @AllowAnonymous
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        String pathError = "error/404";

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                pathError = "error/404";
            }

            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                pathError = "error/500";
            }
        }

        return pathError;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
