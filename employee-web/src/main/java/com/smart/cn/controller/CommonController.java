package com.smart.cn.controller;

import com.smart.cn.entity.Employee;
import com.smart.cn.exception.PhoneIsNullException;
import com.smart.cn.http.AxiosResult;
import com.smart.cn.http.AxiosStatus;
import com.smart.cn.service.EmployeeService;
import com.smart.cn.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 20:49
 */
@RestController
@RequestMapping("common")
//@CrossOrigin
public class CommonController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("getPhone/{phone}")
    public AxiosResult<Void> getPhoneCode(@PathVariable String phone) throws Exception {
        // 首先查询数据库中是否有此手机号
        Employee employee = employeeService.doLogin(phone);
        // 判断
        if (employee == null) {
//            return AxiosResult.error();
            // 抛自定义异常
            throw new PhoneIsNullException(AxiosStatus.VERIFICATION_ERROR);
        }
        // 发送短信

        int code = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
        System.out.println("验证码是：" + code);
        // 使用 redis 存值  设置 5 分钟有效
        stringRedisTemplate.opsForValue().set(phone, code + "", 5, TimeUnit.MINUTES);
        SmsUtils.sendSms(phone, code + "");

        return AxiosResult.success();
    }

    @PostMapping("doLogin")
    // 从前端接受一个对象 (Json数据) 可以 自定义一个实体类   也可以创建一个 Map对象
    public AxiosResult<Void> doLogin(@RequestBody Map<String, String> map) {

        String phone = map.get("phone");
        String code = map.get("code");
        String cd = stringRedisTemplate.opsForValue().get(phone);
        if (code.equals(cd)) {
            //  如果登录成功 之后需要清除 key 值
            stringRedisTemplate.delete(phone);
            return AxiosResult.success();
        }

        throw new PhoneIsNullException(AxiosStatus.LOGIN_ERROR);
    }


}
