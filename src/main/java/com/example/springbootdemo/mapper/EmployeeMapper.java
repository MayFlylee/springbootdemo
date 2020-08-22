package com.example.springbootdemo.mapper;


import com.example.springbootdemo.bean.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public void insertEmp(Employee employee);
}
