package com.smart.cn.service.impl;

import com.github.pagehelper.PageInfo;
import com.smart.cn.entity.Employee;
import com.smart.cn.entity.EmployeeExample;
import com.smart.cn.mapper.EmployeeMapper;
import com.smart.cn.page.PageBean;
import com.smart.cn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 22:12
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee doLogin(String phone) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmployeePhoneEqualTo(phone);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
// 判断是否有值   有的话  返回，没有的话返回null
        if (employees.isEmpty()) {
            return null;
        }
        return employees.get(0);
    }

    @Override
    public PageBean<Employee> findAll() {
        List<Employee> employees = employeeMapper.selectByExample(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        return PageBean.init(pageInfo.getTotal(),employees);
    }
}
