package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
//@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;
    @GetMapping("/emps")
    public Result getByPage(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询员工数据:{},{}",page,pageSize);
        PageBean pageBean = empService.getByPage(page, pageSize);
        return Result.success(pageBean);
    }
    @GetMapping("/list")
    public Result listEmp(){
        log.info("查询全部的员工数据");
        List<Emp> empList=empService.listEmp();
        return Result.success(empList);
    }
}
