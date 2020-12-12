package com.kk.Intercepter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class CommInterceptor extends HandlerInterceptorAdapter {
    private final Logger log = LoggerFactory.getLogger(CommInterceptor.class);
    public static final String LAST_PAGE = "lastPage";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("GET".equalsIgnoreCase(request.getMethod())){
            System.out.println("===>GET");
        }

        Date date = new Date();
        log.info(date + "==============执行顺序: 1、preHandle===============");
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println(requestURI + " <==requestURI\n" + requestURL + " <==requestURL\n" + contextPath + " <==contextPath\n");

        if("/login".equals(requestURI)){
            return true;
        }
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Date date = new Date();
        log.info(date + "==============执行顺序: 2、postHandle================");
        if(modelAndView != null){
            modelAndView.addObject("haha", "测试postHandle");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Date date = new Date();
        log.info(date + "==============执行顺序: 3、afterCompletion================");
    }
}

