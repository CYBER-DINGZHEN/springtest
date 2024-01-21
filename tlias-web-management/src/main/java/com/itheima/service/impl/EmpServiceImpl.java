package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;
    @Override
    public PageBean getByPage(Integer page, Integer pageSize) {
        Integer start = (page-1)*pageSize;
        List<Emp> list = empMapper.getByPage(start, pageSize);
        return new PageBean(empMapper.count(), list);
    }

    @Override
    public List<Emp> listEmp() {
        return empMapper.listEmp();
    }
}
