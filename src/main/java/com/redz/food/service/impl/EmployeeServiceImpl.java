package com.redz.food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.Employee;
import com.redz.food.result.R;
import com.redz.food.service.EmployeeService;
import com.redz.food.mapper.EmployeeMapper;
import com.redz.food.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
* @author rehe
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:19
*/
@Slf4j
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public R<Employee> login(HttpServletRequest request, Employee employee) {
        String md5 = MD5Util.getMD5(employee.getPassword());
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee employee1 = employeeMapper.selectOne(lambdaQueryWrapper);
        if(employee1 == null){
            return R.error("登录失败，用户名不存在");
        }
        if(!md5.equals(employee1.getPassword())){
            return R.error("登录失败，密码错误");
        }
        if (employee1.getStatus() == 0) {
            return R.error("登录失败，账号已禁用");
        }
        request.getSession().setAttribute("employee", employee1.getId());
        return R.success(employee1);
    }

    @Override
    public R<String> addEmployee(HttpServletRequest request,Employee employee) {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee employee1 = employeeMapper.selectOne(lambdaQueryWrapper);
        if(employee1 != null){
            return R.error("新增失败，员工名已存在");
        }
        Long empId = (Long) request.getSession().getAttribute("employee");
        employee.setPassword(MD5Util.getMD5("123456"));
        employee.setCreateTime(new Date());
        employee.setCreateUser(empId);
        employee.setUpdateTime(new Date());
        employee.setUpdateUser(empId);
        Boolean save = save(employee);
        return R.success(save?"新增员工成功":"新增员工失败");
    }

    @Override
    public R<Page> pageQuery(int page, int pageSize, String name) {
        Page<Employee> page1 = new Page(page,pageSize);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(!StringUtils.isEmpty(name),Employee::getName,name);
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        employeeMapper.selectPage(page1, lambdaQueryWrapper);
        return R.success(page1);
    }

}




