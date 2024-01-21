package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    //private static Logger log= LoggerFactory.getLogger(DeptController.class);
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求路径,指定请求方式为GET

    //controller 调用service
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result listdept(){
        //System.out.println("查询全部部门数据");
        log.info("查询全部的部门数据");
        //调用service查询数据
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);}
    @GetMapping("/{id}")
    public Result getDept(@PathVariable Integer id){
        log.info("根据id查找部门");
        Dept dept = deptService.getDept(id);
        //Dept dept1=deptService.getDept(id);
        //dept1.setName("测试");
        return Result.success(dept);
    }
    @DeleteMapping("/{id}")
    public Result deletedept(@PathVariable Integer id){
        //PathVariable注解指定参数为id,路径参数
        log.info("根据id删除部门：{}",id);
        deptService.deleteDept(id);
        return Result.success();
        }
    @PostMapping
    //通过实体类去包装json参数，而通过注解@requstBody
    //responbody 将响应的实体类转为json发送给前端，requestbody将request的json转为实体类给后端
    public Result insertdept(@RequestBody Dept dept){
        log.info("添加部门：{}",dept);
        deptService.insertDept(dept);
        return Result.success();
    }
    @PutMapping
    public Result updatedept(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptService.updateDept(dept);
        return Result.success();
    }
}

