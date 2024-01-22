package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
//-- 根据主键id删除数据
//delete from emp where id=17;
@Delete("delete from emp where id= #{id}")
//#{id}由mybatis提供
//如果mapper接口方法形参只有一个普通类型的参数则{}内属性名可以随便写
    public  int delete(Integer id);

    //新增员工
@Options(keyProperty = "id",useGeneratedKeys = true)
//指定返回的主键往“id”属性中封装
@Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
        "VALUE (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
            //这里属性名都是采用驼峰命名的
    //        "values ('#{username,name,gender,image,job,entrydate,dept_id,creat_time,update_time")
    //    public void insert(String username, String name, short gender, String image, short job, LocalDateTime entrydate,LocalDateTime updatetime);
    //应该选择将多个参数封装为一个对象，便于维护。
public  int insert(Emp emp);

    //更新员工
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}," +
            "entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);


    //根据id查询员工
    @Select("select * from emp where id=#{id}")
    public Emp select(Integer id);

    //条件查询
//    @Select("select *from emp where name like concat('%'+#{name}+'%') and gender =#{gender} " +
//            "and entrydate between #{begin} and #{end} order by update_time desc")
    //使用XML映射文件进行查询

    public List<Emp> list(String name, Short gender,LocalDate begin,LocalDate end);

    //利用动态更新，动态更新员工信息，如果更新时传递有值，则更新;如果更新时没有传递值，则不更新
//    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}," +
//            "entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public void update2(Emp emp);

    //批量删除
    public void deleteByIds(List<Integer> ids);

}
