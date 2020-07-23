package com.garage.web.api.interceptor;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.exception.AuthorizationException;
import com.garage.common.security.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        if (method.isAnnotationPresent(AllowAnonymous.class)) {
            return true;
        }

        if (method.isAnnotationPresent(GetMapping.class) || method.isAnnotationPresent(PutMapping.class) ||
                method.isAnnotationPresent(DeleteMapping.class) || method.isAnnotationPresent(PostMapping.class)) {
            final String authorizationHeader = request.getHeader("Authorization");

            String username = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                username = tokenProvider.extractUsername(jwt);
            }

            if (username == null) {
                throw new AuthorizationException("Bạn chưa đăng nhập. Xin vui lòng đăng nhập.", -1);
            }

            if (!tokenProvider.validateToken(jwt, username)) {
                throw new AuthorizationException("Phiên làm việc của bạn đã hết hạn.", 9);
            }
        }

        return true;
    }
}
