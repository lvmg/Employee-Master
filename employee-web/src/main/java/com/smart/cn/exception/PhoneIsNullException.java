package com.smart.cn.exception;

import com.smart.cn.http.AxiosResult;
import com.smart.cn.http.AxiosStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 22:51
 */
@Getter
@AllArgsConstructor
public class PhoneIsNullException extends RuntimeException{

    AxiosStatus axiosStatus;
}
