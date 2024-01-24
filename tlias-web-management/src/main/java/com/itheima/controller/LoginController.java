package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp loginEmp){
        log.info("登录：{}",loginEmp);
        boolean login =empService.login(loginEmp);
        //登录成功，则生成令牌并下发令牌
        //登录失败则返回error信息
        if(!login){
            return Result.error("用户名或密码错误");
        }
        Map<String, Object> claims=new HashMap<>();
        claims.put("id", loginEmp.getId());
        claims.put("name",loginEmp.getName());
        claims.put("username",loginEmp.getUsername());
        String jwt = JwtUtils.generateJwt(claims);
        return Result.success(jwt);
    }
}
