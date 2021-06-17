package com.smart.cn.http;

import lombok.Data;

/**
 * @Author MG LV
 * @Date Created in 2021/6/15 22:22
 */
@Data
public class AxiosResult<T> {
    private int status;
    private String message;
    private T data;

    private AxiosResult() {
    }

    public static <T> AxiosResult<T> success() {
        return setData(AxiosStatus.SUCCESS, null);
    }

    public static <T> AxiosResult<T> success(T t) {
        return setData(AxiosStatus.SUCCESS, t);
    }

    public static <T> AxiosResult<T> success(AxiosStatus axiosStatus, T t) {
        return setData(axiosStatus, t);
    }

    public static <T> AxiosResult<T> error() {
        return setData(AxiosStatus.ERROR, null);
    }

    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus) {
        return setData(axiosStatus, null);
    }

    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus, T t) {
        return setData(axiosStatus, t);
    }

//    私有化构造函数
    private static <T> AxiosResult<T> setData(AxiosStatus axiosStatus, T t) {
        AxiosResult<T> tAxiosResult = new AxiosResult<>();
        tAxiosResult.setStatus(axiosStatus.getStatus());
        tAxiosResult.setMessage(axiosStatus.getMessage());
        tAxiosResult.setData(t);
        return tAxiosResult;
    }

}
