package com.smart.cn.controller;

import com.github.pagehelper.PageHelper;
import com.smart.cn.entity.Employee;
import com.smart.cn.http.AxiosResult;
import com.smart.cn.page.PageBean;
import com.smart.cn.service.EmployeeService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author MG LV
 * @Date Created in 2021/6/16 23:01
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public AxiosResult<PageBean<Employee>> findAll(int currentPage, int pageSize) {
        // 开启分页
        PageHelper.startPage(currentPage,pageSize);
        PageBean<Employee> pageBean = employeeService.findAll();
        return AxiosResult.success(pageBean);
    }
}
