package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootqsApplicationTests {
    //    @Autowired
//    public UserMapper userMapper;
    @Autowired
    public EmpMapper empMapper;
//    @Test
//    public void test1(){
//        List<User> list = userMapper.list();
//        list.forEach(System.out::println);
//    }

    @Test
    public void test2() {
        int delete = empMapper.delete(26);
        System.out.println(delete);
    }

    @Test
    public void testinsert() {
        Emp emp = new Emp();
        //emp.setId(16);
        emp.setName("汤姆");
        emp.setUsername("TOM");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setImage("1.jpg");
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }
    @Test
    public void testupdate() {
        Emp emp = new Emp();
        emp.setId(28);
        emp.setName("汤姆1");
        emp.setUsername("TOM1");
        emp.setGender((short) 1);
        //emp.setJob((short) 1);
        emp.setImage("1.jpg");
        emp.setDeptId(1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        //emp.setCreateTime(LocalDateTime.now());
        empMapper.update(emp);
        //System.out.println(emp.getId());
    }
    @Test
    public void selettest(){
            Emp emp= empMapper.select(28);
        System.out.println(emp);
        //封装时由于字段名字和属性名不一样导致部分属性不会被封装进去
        //可以采用三种方法，起别名，用result手动映射，打开mybatis的自动映射开关
    }
    @Test
    public void listtest(){
//        List<Emp> list=empMapper.list
//                ("张",(short) 1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
        List<Emp> list = empMapper.list("张", (short) 1, null, null);
        System.out.println(list);
    }
    @Test
    public void testupdate2() {
        Emp emp = new Emp();
        emp.setId(28);
        emp.setName("汤姆2");
        emp.setUsername("TOM222");
        emp.setGender((short) 2);
        //emp.setJob((short) 1);
        //emp.setImage("1.jpg");
        //emp.setDeptId(1);
        //emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        //emp.setCreateTime(LocalDateTime.now());
        empMapper.update2(emp);
        //System.out.println(emp.getId());
    }

    @Test
    public void testDeleteByIds(){
        List<Integer>ids= Arrays.asList(13,14,15);
        empMapper.deleteByIds(ids);
    }
}