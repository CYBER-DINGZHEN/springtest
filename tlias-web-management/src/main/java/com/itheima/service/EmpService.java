package com.itheima.service;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface EmpService {
    //PageBean getByPage(Integer page, Integer pageSize);
    List<Emp> listEmp();
    //PageBean list(Integer page, Integer pageSize);

    PageBean list(Integer page, Integer pageSize, String name, Short gender, String begin, String end);
    void deleteEmp(List<Integer> ids);
}
