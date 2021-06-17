package com.smart.cn.utils;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;


/**
 * @Author MG LV
 * @Date Created in 2021/6/15 23:13
 */
@Log4j
public class SmsUtils {
    //  获取日志对象
//    static Logger logger = Logger.getLogger(SmsUtils.class);

    private static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }


    public static void sendSms(String phone, String code) {
        try {
            com.aliyun.dysmsapi20170525.Client client = SmsUtils.createClient("LTAI5tKVVu8yPJbDBuNdk5bu", "c1A1vBMmtdUBdcSDXMSO0dNOcvww6F");
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(phone)
                    .setSignName("尚马十九期辉哥")
                    .setTemplateCode("SMS_183240934")
                    .setTemplateParam("{\"code\":" + code + "}");
            // 复制代码运行请自行打印 API 的返回值
            client.sendSms(sendSmsRequest);
        } catch (Exception e) {
            // 打印
            log.error(phone+" 验证码发送错误 "+e.getMessage());
            e.printStackTrace();
        }
    }

}
