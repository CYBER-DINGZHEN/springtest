package com.itheima.filter;


import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class WebLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("--------------------拦截到请求，开始执行放行前的操作-------------------");
        //获取请求url，判断是否是登录相关的资源
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        log.info("请求的url是：{}", url);
        //如果是登录相关的资源，直接放行
        if (url.contains("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("登录相关的资源，放行");
            return;
        }
        //如果不是登录相关的资源，判断是否登录，利用token
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("jwt为空，用户未登录");
            Result error= Result.error("NOT_LOGIN");
            //将对象转换成json字符串,因为不在controller中，所以需要手动转换
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("jwt解析失败，用户未登录");
            Result error= Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }
        //如果登录了，放行
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("用户已登录，放行");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
