package com.itheima.service;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.FileVisitOption;
import java.util.List;

public interface DeptService {
    List<Dept> list();//用于查询全部部门数据,让实现类去实现这个方法

    void deleteDept(Integer id);

    void insertDept(Dept dept);

    void updateDept(Dept dept);

    Dept getDept(Integer id);
}
