package com.zhhe.chapter21;

import com.zhhe.chapter21.component.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter21ApplicationTests
{
    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void contextLoads()
    {
        Assert.assertEquals(blogProperties.getName(), "zhhe");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot");
        System.out.println(blogProperties.getName().equals("zhhe"));
        System.out.println(blogProperties.getTitle().equals("Spring Boot"));

        System.out.println(blogProperties.getDesc());
        System.out.println("测试启动");

    }

    @Test
    public void getRandomVal()
    {
        System.out.println(blogProperties.getValue());
        System.out.println(blogProperties.getNumber());
        System.out.println(blogProperties.getBignumber());
        System.out.println(blogProperties.getTest1());
        System.out.println(blogProperties.getTest2());
    }

    @Test
    public void getProfiles()
    {
        System.out.println(blogProperties.getProfiles());
    }

}
