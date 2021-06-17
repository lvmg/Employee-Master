package com.smart.cn.service;

import com.smart.cn.entity.Employee;
import com.smart.cn.mapper.EmployeeMapper;
import com.smart.cn.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 22:10
 */
@Service
public interface EmployeeService {
    Employee doLogin(String phone);


    PageBean<Employee> findAll();
}

