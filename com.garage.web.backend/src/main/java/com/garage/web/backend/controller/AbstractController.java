package com.garage.web.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.garage.web.backend.consts.WebConsts;

@Controller
public abstract class AbstractController {
    protected Long getUserId(HttpServletRequest request) {
        return (Long) request.getSession(false).getAttribute(WebConsts.USER_ID);
    }
}
