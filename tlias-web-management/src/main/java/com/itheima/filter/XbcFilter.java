package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class XbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("abc拦截到， 开始执行放行前的操作");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);//放行操作

        System.out.println("abc拦截到， 开始执行放行后的操作");
    }
}
