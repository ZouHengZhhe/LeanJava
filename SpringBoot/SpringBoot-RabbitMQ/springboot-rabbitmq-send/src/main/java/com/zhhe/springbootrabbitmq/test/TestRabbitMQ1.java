package com.zhhe.springbootrabbitmq.test;

import com.zhhe.springbootrabbitmq.Producer.MsgProducer1;
import com.zhhe.springbootrabbitmq.SpringbootRabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-20 10:56
 */
@SpringBootTest(classes= SpringbootRabbitmqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ1
{
    @Autowired
    private MsgProducer1 p1;

    @Test
    public void testRabbit()
    {
        p1.send();
    }

    @Test
    public void testRabbit2()
    {
        p1.send2("exchange", "topic.message", "hello,rabbit!");
    }
    @Test
    public void testRabbit3()
    {
        p1.send3("fanoutExchange", "hello,rabbit!");
    }

}
