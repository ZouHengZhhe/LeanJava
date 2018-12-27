package com.sikiedu.shakes.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-12-05 14:40
 */
@RestController
public class UserController
{
    @RequestMapping("/sms")
    public ModelAndView sms(String telephone, HttpServletResponse response) throws HTTPException, IOException
    {
//        System.out.println("我已经到这");
        //发送手机验证码
        int appid=1400162167;
        String appkey="bd13a94b7818ec19c14cdd2231f8e0e0";
        int templateId=229704;
        String sign="zhhe公众号";

        //要发送的验证码
        Random random = new Random();
        String sms=""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
        String[] params=new String[1];
        params[0]=sms;
        System.out.println("验证码为："+sms);

        //通过sender发送
        SmsSingleSender smsSingleSender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result=smsSingleSender.sendWithParam("86", telephone, templateId, params, sign, "", "");
        System.out.println(result);

        //代表已经成功
        response.getWriter().write("{\"success\":"+true+"}");

        return null;
    }
}
