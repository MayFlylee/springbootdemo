package com.example.springbootdemo.mapper;
import com.example.springbootdemo.bean.Department;
import org.apache.ibatis.annotations.*;
/*使用注解的方式整合MyBatis，
实际开发中一般简单的项目使用注解版，如果复杂*/
/*创建一个操作数据库的配置类*/
@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDepartment(Integer id);
    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);
    /*设置id为封装组件用*/
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
