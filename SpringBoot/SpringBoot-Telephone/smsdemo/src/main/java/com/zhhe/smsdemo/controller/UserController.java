package com.zhhe.smsdemo.controller;

import com.github.qcloudsms.httpclient.HTTPException;
import com.zhhe.smsdemo.domain.User;
import com.zhhe.smsdemo.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.github.qcloudsms.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-19 9:19
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, Model model)
    {
        String message= (String) request.getSession().getAttribute("message");
        model.addAttribute("message",message);
        return new ModelAndView("/index.html","userModel",model);
    }

    @RequestMapping("/login.action")
    public ModelAndView login(User user,HttpServletRequest request)
    {
        User loginUser=userServiceImpl.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (loginUser==null)
        {
            //用户不存在
            request.getSession().setAttribute("message", "用户名或密码错误！！");
            return new ModelAndView("redirect:/");
        }
        else
        {
            if (loginUser.getState()==0)
            {
                //用户未激活
                request.getSession().setAttribute("message", "用户未激活！！");
                return new ModelAndView("redirect:/");
            }
            else
            {
                return new ModelAndView("/welcome.html");
            }
        }

    }

    @RequestMapping("/register.action")
    public ModelAndView register(User user,HttpServletRequest request) {
       user.setState(0);

       //用户之前填写的验证码，通过表单提交过来
       String usersms=user.getCode();
       //系统随机产生的验证码
       String sms= (String) request.getSession().getAttribute("sms");
       user.setCode(sms);

       userServiceImpl.save(user);  //将用户存入数据库

        if (usersms.equals(sms))
        {
            //改变用户状态，激活,state 0 变 1
            userServiceImpl.changeUserState(user.getTelephone(), user.getUsername(), user.getPassword());
            request.getSession().setAttribute("message", "注册成功！！");
        }
        else
        {
            //验证码错误
            request.getSession().setAttribute("message", "输入验证码错误，请重新激活！！");
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/activeUser.action")
    public ModelAndView activeUser(User user,HttpServletRequest request)
    {
        User activeUser=userServiceImpl.findUserByUsernameAndPasswordAndTelephone(user.getUsername(), user.getPassword(), user.getTelephone());

        if (activeUser.getCode().equals(user.getCode()))
        {
            //用户激活
            userServiceImpl.changeUserState(activeUser.getTelephone(), activeUser.getUsername(), activeUser.getPassword());
            request.getSession().setAttribute("message", "激活成功！！");
        }
        else
        {
            //激活失败
            request.getSession().setAttribute("message", "验证码错误，请填写正确的验证码！！");
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/sms.action")
    public ModelAndView sms(HttpServletRequest request, HttpServletResponse response, String telephone) throws IOException {

        int appid=1400162167;
        String appkey="bd13a94b7818ec19c14cdd2231f8e0e0";
        int temlpateId=229704;  //短信正文ID
        String smsSign="zhhe公众号";  //短信签名内容

        String phoneNumber=telephone;

        Random random = new Random();
        //字符串拼接
        String sms=""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
        //将验证码放入session中
        request.getSession().setAttribute("sms", sms);
        String[] params=new String[1];
        params[0]=sms;
        System.out.println(sms);

        SmsSingleSender ssender=new SmsSingleSender(appid, appkey);
        try {
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, temlpateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            e.printStackTrace();
        }

        response.getWriter().write("{\"success\":true}");

        return null;
    }
}
