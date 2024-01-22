package com.itheima.mapper;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Mapper
public interface EmpMapper {
    //List<Emp> getByPage(Integer start, Integer pageSize);
    public List<Emp> listEmp();
    //public long count();
    public List<Emp> list(String name,
                          Short gender,
                          String begin,
                          String end);//员工信息查询，利用了helper插件

    void deleteEmp(List<Integer> ids);

    void insertEmp(Emp emp);

    void updateEmp(Emp emp);

    Emp getEmp(Integer id);
}
