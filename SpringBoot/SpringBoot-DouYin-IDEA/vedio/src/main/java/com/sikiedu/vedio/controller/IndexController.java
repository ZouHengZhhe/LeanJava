package com.sikiedu.vedio.controller;

import com.sikiedu.vedio.utils.Signature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-22 15:27
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public ModelAndView index()
    {
        return new ModelAndView("video.html");
    }

    @RequestMapping("/sign")
    @ResponseBody
    public String getSign()
    {
        //得到Sign
        Signature sign = new Signature();
        sign.setSecretId("AKIDsZ2GE1pu2vbSClvHCwUo00nLgolVrNYU");
        sign.setSecretKey("qSp0yhIjvugHhwypUu51jFWbYMwGLDvO");
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        sign.setSignValidDuration(3600 * 24 * 2);
        String signature=null;
        try {
            signature = sign.getUploadSignature();
            System.out.println("signature : " + signature);
        } catch (Exception e) {
            System.out.print("获取签名失败");
            e.printStackTrace();
        }

        return signature;
    }

    @RequestMapping("/plus")
    public ModelAndView plus()
    {
        return new ModelAndView("/video-plus.html");
    }

    @RequestMapping("/start")
    public ModelAndView start()
    {
        return new ModelAndView("/start.html");
    }

    @RequestMapping("/start2")
    public ModelAndView start2()
    {
        return new ModelAndView("/start2.html");
    }
}
