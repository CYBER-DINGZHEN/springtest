package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源方法运行前运行，返回true放行，返回false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------preHandle------");
        String url = request.getRequestURI();
        log.info("请求的url是：{}", url);
        if(url.contains("/login")){
            log.info("登录相关的资源，放行");
            return true;
        }
        String token = request.getHeader("token");
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("jwt解析失败，用户未登录");
            Result error= Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        log.info("用户已登录，放行");
        return true;
    }

    @Override//目标资源方法运行后，视图资源方法运行前运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("------postHandle------");
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//视图资源方法运行后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("------afterCompletion------");
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
