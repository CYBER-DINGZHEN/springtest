package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
   @Autowired
    public DeptMapper deptmapper;

    @Override
    public List<Dept> list() {
         return deptmapper.listdept();
    }

    @Override
    public void deleteDept(Integer id) {
        deptmapper.deleteDept(id);
    }

    @Override
    public void insertDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.insertDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.updateDept(dept);
    }

    @Override
    public Dept getDept(Integer id) {
        return deptmapper.getDept(id);
    }
}
