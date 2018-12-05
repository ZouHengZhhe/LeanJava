package com.sikiedu.sms.com.sikiedu.sms.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-16 10:48
 */
@RestController
public class UserController
{
    @RequestMapping("/test")
    public String test()
    {
        //给手机发送短信
        //1AppID(int)
        int appid=1400162167;

        //2AppKey(String)
        String appkey="bd13a94b7818ec19c14cdd2231f8e0e0";

        //3短信的模板ID(int)
        int templateID=229704;

        //4签名的名字(String)
        String smsSign="zhhe公众号";

        //给谁发
        String phoneNumber="15618028732";

        //验证码
        String[] params={"1234"};

        SmsSingleSender ssender=new SmsSingleSender(appid, appkey);
        //参数：地区、电话、使用的模板ID、验证码、签名
        try
        {
            SmsSingleSenderResult result=ssender.sendWithParam("86", phoneNumber, templateID, params, smsSign, "", "");
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
