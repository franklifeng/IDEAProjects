package com.springboot.cache.service;

import com.springboot.cache.bean.Employee;
import com.springboot.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author frank
 * @create 2019-08-19 15:54
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"})
    public Employee getEmployeeById(Integer id){
        System.out.println("stat============");
        Employee  emp = employeeMapper.getEmployee(id);
        return emp;
    }

}
