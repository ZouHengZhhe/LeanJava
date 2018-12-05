package com.sikiedu.vediodemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-22 14:58
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index()
    {
        return new ModelAndView("/index.html");
    }
}
