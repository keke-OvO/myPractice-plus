package com.kk.Intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class CommInterceptor extends HandlerInterceptorAdapter {

    public static final String LAST_PAGE = "lastPage";
    private final Logger log = LoggerFactory.getLogger(CommInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            Date date = new Date();
            System.out.println("===>GET放行");
            log.info(date + "\n==============preHandle执行顺序: 1、preHandle===============");
            return true;
        }
        log.info("===拦截===");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Date date = new Date();
        log.info(date + "\n==============postHandle执行顺序: 2、postHandle================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Date date = new Date();
        log.info(date + "\n==============afterCompletion执行顺序: 3、afterCompletion================");
    }
}

