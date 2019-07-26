package com.study.boot.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dranawhite
 * @version $Id: WebFilter.java, v 0.1 2019-01-15 20:41 dranawhite Exp $$
 */
public class WebFilter extends AbstractFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Coming into Service!");
        ThreadLocalUtils.set(request.hashCode());
        filterChain.doFilter(request, response);
        System.out.println("Coming out Service!");
    }
}
