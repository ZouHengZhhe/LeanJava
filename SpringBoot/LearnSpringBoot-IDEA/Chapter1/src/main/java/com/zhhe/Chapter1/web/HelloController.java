package com.zhhe.Chapter1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-22 17:14
 */
@RestController
public class HelloController
{
    @RequestMapping("/hello")
    public String index()
    {
        return "Hello World";
    }
}
