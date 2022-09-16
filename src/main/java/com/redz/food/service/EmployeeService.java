package com.redz.food.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redz.food.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.redz.food.result.R;

import javax.servlet.http.HttpServletRequest;

/**
* @author rehe
* @description 针对表【employee(员工信息)】的数据库操作Service
* @createDate 2022-09-06 14:22:19
*/
public interface EmployeeService extends IService<Employee> {

    R<Employee> login(HttpServletRequest request, Employee employee);

    R<String> addEmployee(HttpServletRequest request,Employee employee);

    R<Page> pageQuery(int page, int pageSize, String name);

}
