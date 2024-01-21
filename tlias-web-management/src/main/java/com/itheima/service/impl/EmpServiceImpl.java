package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
//    @Override
//    public PageBean getByPage(Integer page, Integer pageSize) {
//        Integer start = (page-1)*pageSize;
//        List<Emp> list = empMapper.getByPage(start, pageSize);
//        return new PageBean(empMapper.count(), list);
//    }

    @Override
    public List<Emp> listEmp() {
        return empMapper.listEmp();
    }
    public PageBean list(Integer page, Integer pageSize,String name, Short gender, String begin, String end) {
        //分页插件设置分页参数
        PageHelper.startPage(page, pageSize);

        //查询数据
        List<Emp> list = empMapper.list(name,gender, begin, end);//这里返回的是Page<Emp>类型的，因为在EmpMapper.xml中配置了
        //封装分页结果
        Page<Emp> p= (Page<Emp>) list;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteEmp(List<Integer> ids) {
        empMapper.deleteEmp(ids);
    }
}
