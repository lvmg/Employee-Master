package com.smart.cn.config;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author MG LV
 * @Date Created in 2021/6/16 19:36
 */
public class PropertiesConfig {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(PropertiesConfig.class.getResourceAsStream("aliyunSms.properties"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getProperties(){
        String endpoint = properties.getProperty("endpoint");
        String accessKeyId = properties.getProperty("accessKeyId");
        String accessKeySecret = properties.getProperty("accessKeySecret");
        String signName = properties.getProperty("signName");
        String templateCode = properties.getProperty("templateCode");
    }
}
