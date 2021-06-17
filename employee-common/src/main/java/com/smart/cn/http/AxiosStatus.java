package com.smart.cn.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 22:30
 */
@Getter     // get 方法
@AllArgsConstructor // 构造函数
public enum AxiosStatus {
    SUCCESS(20000, "成功"),
    LOGIN_SUCCESS(20100,"登录成功"),
    ERROR(40000, "错误"),
    LOGIN_ERROR(40100,"登录失败"),
    VERIFICATION_ERROR(40444, "手机号码错误或不存在");
    private int status;
    private String message;

}
