package com.example.springbootdemo.controller;



import com.example.springbootdemo.dao.DepartmentDao;
import com.example.springbootdemo.dao.EmployeeDao;
import com.example.springbootdemo.entities.Department;
import com.example.springbootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        //thymeleaf会自定拼串
        return "emp/list";

    }

    /*进入员工添加页面*/
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //显示所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /*员工添加*/
    //SpringMVC将会自动把请求的参数和入参对象的属性进行一一绑定，因此需要页面请求参数名字和javaBean中的对象属性一致
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        /*来到员工列表页面*/
        System.out.println("保存的员工信息：" + employee);
        /*保存员工*/
        employeeDao.save(employee);
        /*
         * redirect:表示重定向到一个地址，/代表当前项目的路径
         * forward：表示转发到一个地址
         * */
        return "redirect:/emps";
    }

    /*进入员工修改页面*/
    @GetMapping("/emp/{id}")
    public String toEditPage(
            @PathVariable("id") Integer id,
            Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        /*显示部门*/
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /*完成员工修改:需要提交员工ID*/
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改员工的数据" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /*处理删除请求*/
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
