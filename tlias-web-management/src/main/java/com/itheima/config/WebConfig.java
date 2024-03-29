package com.itheima.config;

import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration//声明当前类是一个配置类
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {//添加拦截器
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");
    }
}
