package com.smart.cn.page;

import lombok.Data;

import java.util.List;

/**
 * @Author MG LV
 * @Date Created in 2021/6/17 0:29
 */
@Data
public class PageBean<T> {
    private long total;
    private List<T> list;

    private PageBean(){}

    public static <T> PageBean<T> init(long total, List<T> list){
        PageBean<T> pageBean = new PageBean<>();
        pageBean.setList(list);
        pageBean.setTotal(total);
        return pageBean;
    }
}
