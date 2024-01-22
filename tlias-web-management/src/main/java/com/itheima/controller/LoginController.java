package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp loginEmp){
        log.info("登录：{}",loginEmp);
        boolean login =empService.login(loginEmp);
        if(!login){
            return Result.error("用户名或密码错误");
        }
        return Result.success();
    }
}
