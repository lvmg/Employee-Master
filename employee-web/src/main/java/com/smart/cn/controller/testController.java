package com.smart.cn.controller;

import com.smart.cn.entity.Employee;
import com.smart.cn.mapper.EmployeeMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 17:19
 */
@RestController
public class testController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("test")
    public String test() {
        return "succeed";
    }

    @RequestMapping("findAll")
    public List<Employee> findAll() {
        return employeeMapper.selectByExample(null);
    }

    @GetMapping("RedisTest")
    public String RedisTest() {
        // 分别对应的对  key-value 的操作 list  hash  set
//        redisTemplate.opsForValue().set("姓名", "张小三");
//        Object o = redisTemplate.opsForValue().get("姓名");
//        System.out.println(o);
//        System.out.println("=============");

        stringRedisTemplate.opsForValue().set("姓名", "张小三");
        Object o = stringRedisTemplate.opsForValue().get("姓名");
        System.out.println(o);
//        Employee employee = new Employee();
//        employee.setEmployeeName("zhangSan");
//        redisTemplate.opsForValue().set("employee",employee);
//        System.out.println(redisTemplate.opsForValue().get("employee"));

//        redisTemplate.opsForList();
//        redisTemplate.opsForHash();
//        redisTemplate.opsForSet();
        return o+"";
    }

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
