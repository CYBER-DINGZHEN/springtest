package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override//初始化，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("我是过滤器，我初始化了");
    }

    @Override//每次拦截到请求时调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是过滤器，拦截到， 开始执行放行前的操作");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);//放行操作

        System.out.println("我是过滤器，拦截到， 开始执行放行后的操作");
    }

    @Override//销毁的方法，也只调用一次
    public void destroy() {
        Filter.super.destroy();
        System.out.println("我是过滤器，我销毁了");
        //System.out.println("destroy");
    }
}
