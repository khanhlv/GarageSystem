package com.garage.web.api.interceptor;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.exception.AuthorizationException;
import com.garage.common.exception.SystemException;
import com.garage.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        if (method.isAnnotationPresent(AllowAnonymous.class)) {
            return true;
        }

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtTokenUtil.extractUsername(jwt);
        }

        if (username != null) {
            if (!jwtTokenUtil.validateToken(jwt, username)) {
                throw new AuthorizationException("REST signature failed validation.");
            }
        }

        return true;
    }
}
