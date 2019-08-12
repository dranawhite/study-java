package com.dranawhite.study.springboot.filter;

import com.dranawhite.study.springboot.security.CustomUserServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter属于Servlet, Interceptor属于Spring, Interceptor本身与Spring结合紧密, 功能更齐全，推荐优先使用Interceptor
 *
 * Filter和拦截器执行顺序
 * <pre>
 *     Filter Request
 *     Interceptor preHandler
 *     Interceptor postHandler
 *     Interceptor afterCompletion
 *     Filter Response
 * </pre>
 *
 * @author dranawhite
 * @version : LoginFilter.java, v 0.1 2019-07-27 16:57 dranawhite Exp $$
 */
@Component
public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserServiceImpl customUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        SecurityContextHolder.clearContext();
        if (StringUtils.isEmpty(token)) {
            throw new AuthenticationCredentialsNotFoundException("无效的用户名/密码");
        }

        UserDetails user = customUserService.loadUserByUsername(token);
        if (user == null) {
            throw new AccessDeniedException("用户已失效");
        }

        // 将当前用户放入上下文中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, token,
                user.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
