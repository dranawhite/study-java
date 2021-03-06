package com.dranawhite.study.springboot.security;

import com.dranawhite.common.exception.DranaAccessException;
import com.dranawhite.common.exception.GenericResultCode;

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
        throw new DranaAccessException("无权操作!", GenericResultCode.FORBIDDEN);
    }
}
