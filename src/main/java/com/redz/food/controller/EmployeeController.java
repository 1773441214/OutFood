package com.redz.food.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redz.food.entity.Employee;
import com.redz.food.result.R;
import com.redz.food.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public R<Employee> login(HttpServletRequest request,@RequestBody Employee employee){
        R<Employee> result = employeeService.login(request,employee);
        return result;
    }

    @RequestMapping(value="/logout",method= RequestMethod.POST)
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前员工登录的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    @RequestMapping(method= RequestMethod.POST)
    public R<String> addEmployee(HttpServletRequest request,@RequestBody Employee employee){
        R<String> result = employeeService.addEmployee(request,employee);
        return result;
    }

    @RequestMapping(value="/page",method= RequestMethod.GET)
    public R<Page> page(int page, int pageSize, String name){
        R<Page> result = employeeService.pageQuery(page,pageSize,name);
        return result;
    }

    @PutMapping
    public R<String> updateStatus(HttpServletRequest request,@RequestBody Employee employee){
        Long empId = (Long) request.getSession().getAttribute("employee");
        employee.setUpdateTime(new Date());
        employee.setUpdateUser(empId);
        employeeService.updateById(employee);
        return R.success("员工信息修改成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable String id){
        Employee emp = employeeService.getById(id);
        if(emp!=null){
            return R.success(emp);
        }
        return R.error("没有查询到该用户信息");
    }

}
