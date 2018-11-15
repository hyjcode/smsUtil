package cn.hy.core;

import cn.hy.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

	//监听消息(消息中间件)
    @JmsListener(destination = "send_sms")
    public void sendSms(Map<String, String> paramMap) throws Exception {
        smsUtil.sendSms(paramMap);
    }
}
