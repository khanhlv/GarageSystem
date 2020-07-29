package com.garage.web.backend.interceptor;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.garage.common.anotation.AllowAnonymous;
import com.garage.common.exception.AccessDeniedException;
import com.garage.web.backend.consts.WebConsts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        if (method.isAnnotationPresent(AllowAnonymous.class)) {
            return true;
        }

        String returnPath = returnPath(request);

        HttpSession session = request.getSession();

        Long userId = (Long) session.getAttribute(WebConsts.USER_ID);

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/login?returnPath=" + returnPath(request));

            return false;
        }

        List<String> permissionList = (ArrayList<String>) session.getAttribute(WebConsts.USER_PERMISSION);

        if (permissionList != null && permissionList.size() > 0) {
            String pattern = String.join("|", permissionList);

            if (!returnPath.matches(pattern)) {
                throw new AccessDeniedException("Access Denied");
            }
        }

        return true;
    }

    private String returnPath(HttpServletRequest request) throws UnsupportedEncodingException {
        String uri = request.getRequestURI().replaceFirst(request.getContextPath(), StringUtils.EMPTY);
        String query = request.getQueryString();
        if (StringUtils.isEmpty(query)) {
            return uri;
        }
        return uri.concat("?").concat(URLEncoder.encode(query, StandardCharsets.UTF_8.toString()));
    }
}
