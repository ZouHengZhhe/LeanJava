package com.sikiedu.shakes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-12-05 9:52
 */
@RestController
public class ToController
{
    @RequestMapping("/toindex")
    public ModelAndView index()
    {
        return new ModelAndView("/index.html");
    }

    @RequestMapping("/tologin")
    public ModelAndView login()
    {
        return new ModelAndView("/login.html");
    }

    @RequestMapping("/tomusic-people")
    public ModelAndView musicPeople()
    {
        return new ModelAndView("/music-people.html");
    }

    @RequestMapping("/toregister")
    public ModelAndView register()
    {
        return new ModelAndView("/register.htm");
    }
}
