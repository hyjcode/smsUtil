package cn.hy.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms")
public class SmsTest {
    @Autowired
    private JmsMessagingTemplate  jmsTemplate;

    @RequestMapping("/send")
    public void smsSend(){
        //随机六位数密码
        long code =  (long) (Math.random() * 1000000.0);
        System.out.println("====code====" + code);
        System.out.println("====code====" + code);

        //将短信内容, 用户名, 密码, 签名, 模板编号等组成map发送给消息服务器
        Map<String, String> map = new HashMap();
        map.put("accessKeyId", "LTAIJhLMS3hvK5XF");
        map.put("accessKeySecret", "y2xIQpuZw4bwHxcZY1bKyLlrEUMBxV");
        map.put("PhoneNumber", "15738896884");
        map.put("templateParam", "{\"code\":\"" + code + "\"}");
        map.put("signName", "品优购");
        map.put("templateCode", "SMS_150860861");

		//发送消息(消息中间件)
       jmsTemplate.convertAndSend("send_sms", map);
    }

}
