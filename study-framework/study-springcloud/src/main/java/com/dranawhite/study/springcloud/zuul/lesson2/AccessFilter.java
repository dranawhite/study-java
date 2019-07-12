package com.dranawhite.study.springcloud.zuul.lesson2;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul过滤器
 *
 * @author dranawhite
 * @version : AccessFilter.java, v 0.1 2019-07-12 11:31 dranawhite Exp $$
 */
public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        // 过滤器类型，决定了过滤器在请求的哪个生命周期中执行;pre表示在请求被路由之前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤器的执行顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 判断该过滤器是否需要被执行，如果返回true，则所有请求都生效
        return true;
    }

    @Override
    public Object run() {
        // 检查请求中是否带accessToken字段，如果没带就返回401错误
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
