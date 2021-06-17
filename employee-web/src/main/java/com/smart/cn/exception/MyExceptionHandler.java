package com.smart.cn.exception;

import com.smart.cn.http.AxiosResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 22:58
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(PhoneIsNullException.class)
    public AxiosResult<Void> myHandler(PhoneIsNullException e) {
        return AxiosResult.error(e.getAxiosStatus());

    }

}
