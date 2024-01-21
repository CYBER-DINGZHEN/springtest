package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    public List<Dept> listdept();


    public void deleteDept(Integer id);

    void insertDept(Dept dept);

    void updateDept(Dept dept);

    Dept getDept(Integer id);
}
