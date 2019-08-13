package com.dranawhite.study.springboot.security;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.request.DranaForbiddenException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dranawhite
 * @version : HttpAccessDeniedHandler.java, v 0.1 2019-08-12 13:47 dranawhite Exp $$
 */
public class HttpAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        throw new DranaForbiddenException("无权操作!", ResultCodeEnum.NOT_SUPPORTED);
    }
}
