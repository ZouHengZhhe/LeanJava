package com.zhhe.springbootrabbitmq.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-20 11:41
 */
@Component
public class MsgReceive2 {
    @RabbitListener(queues = "topic.message")
    public void process1(String str)
    {
        System.out.println("message: "+str);
    }

    @RabbitListener(queues = "topic.messages")
    public void process2(String str)
    {
        System.out.println("messages: "+str);
    }
}
