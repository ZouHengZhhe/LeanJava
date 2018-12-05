package com.zhhe.chapter21.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-22 17:27
 */
@Component
public class BlogProperties
{
    //利用该注解可以获得application.properties中的自定义属性值
    @Value("${com.zhhe.blog.name}")
    private String name;

    @Value("${com.zhhe.blog.title}")
    private String title;

    @Value("${com.zhhe.blog.desc}")
    private String desc;

    //application.properties中生成随机数
    @Value("${com.zhhe.blog.value}")
    private String value;
    @Value("${com.zhhe.blog.number}")
    private int number;
    @Value("${com.zhhe.blog.bignumber}")
    private long bignumber;
    @Value("${com.zhhe.blog.test1}")
    private int test1;
    @Value("${com.zhhe.blog.test2}")
    private int test2;
    @Value("${com.zhhe.myValue}")
    private String profiles;

    public String getProfiles()
    {
        return profiles;
    }

    public String getValue()
    {
        return value;
    }

    public int getNumber()
    {
        return number;
    }

    public long getBignumber()
    {
        return bignumber;
    }

    public int getTest1()
    {
        return test1;
    }

    public int getTest2()
    {
        return test2;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }
}
