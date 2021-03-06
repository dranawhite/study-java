package com.dranawhite.study.springboot.security;

import com.dranawhite.common.exception.DranaAccessException;
import com.dranawhite.common.exception.DranaAuthorizationException;
import com.dranawhite.common.exception.GenericResultCode;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Http状态处理
 *
 * @author dranawhite
 * @version : HttpAuthenticationEntryPoint.java, v 0.1 2019-08-12 11:16 dranawhite Exp $$
 */
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        if (authException instanceof InsufficientAuthenticationException) {
            throw new DranaAccessException("无权操作!", GenericResultCode.FORBIDDEN);
        } else {
            throw new DranaAuthorizationException("请重新登录!", GenericResultCode.UNAUTHORIZED);
        }
    }
}
