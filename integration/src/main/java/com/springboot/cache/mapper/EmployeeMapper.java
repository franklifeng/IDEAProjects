package com.springboot.cache.mapper;

import com.springboot.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author frank
 * @create 2019-08-19 14:07
 */
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    public Employee getEmployee(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public Employee updateEmployee(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmployee(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
}
