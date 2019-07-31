package com.dranawhite.study.springboot.interceptor;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接口耗时统计
 *
 * @author dranawhite
 * @version : InterfaceCostTimeInterceptor.java, v 0.1 2019-07-31 10:52 dranawhite Exp $$
 */
@Slf4j
public class InterfaceCostTimeInterceptor implements HandlerInterceptor {

    private ConcurrentHashMap<String, CostTimeStatistics> costTimeMap = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (isSkipInterceptor(handler)) {
            return true;
        }

        CostTimeStatistics statistics = costTimeMap.get(request.getRequestURI());
        if (statistics == null) {
            statistics = new CostTimeStatistics();
        }
        statistics.setStartTime(System.currentTimeMillis());
        costTimeMap.put(request.getRequestURI(), statistics);
        log.info("接口{}开始时间[{}]", request.getRequestURI(), statistics.getStartTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView view) {
        if (isSkipInterceptor(handler)) {
            return;
        }

        CostTimeStatistics statistics = costTimeMap.get(request.getRequestURI());
        statistics.setEndTime(System.currentTimeMillis());
        costTimeMap.put(request.getRequestURI(), statistics);
        log.info("接口{}结束时间[{}]", request.getRequestURI(), statistics.getEndTime());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) {
        if (isSkipInterceptor(handler)) {
            return;
        }

        CostTimeStatistics statistics = costTimeMap.get(request.getRequestURI());
        log.info("接口{}执行时间[{}]", request.getRequestURI(), statistics.endTime - statistics.startTime);
    }

    private boolean isSkipInterceptor(Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CostTime costTimeAnno = handlerMethod.getMethodAnnotation(CostTime.class);
        return costTimeAnno == null;
    }

    @Setter
    @Getter
    static class CostTimeStatistics {

        long startTime;

        long endTime;
    }
}
