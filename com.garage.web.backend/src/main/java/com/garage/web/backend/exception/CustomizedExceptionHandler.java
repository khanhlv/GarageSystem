package com.garage.web.backend.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.garage.common.exception.AccessDeniedException;
import com.garage.common.exception.SystemException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Controller
@Slf4j
public class CustomizedExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public final String handleException(AccessDeniedException ex, Model model) {

        log.error("AccessDeniedException", ex);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        model.addAttribute("timestamp", simpleDateFormat.format(new Date()));
        model.addAttribute("message", ex.getMessage());

        return "exception/accessDenied";
    }

    @ExceptionHandler(SystemException.class)
    public final String handleException(SystemException ex, Model model) {

        log.error("SystemException", ex);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        model.addAttribute("timestamp", simpleDateFormat.format(new Date()));
        model.addAttribute("message", ex.getMessage());

        return "exception/system";
    }

}
