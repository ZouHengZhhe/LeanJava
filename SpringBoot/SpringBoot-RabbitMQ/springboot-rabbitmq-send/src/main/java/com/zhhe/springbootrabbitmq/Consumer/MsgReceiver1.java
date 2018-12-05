package com.zhhe.springbootrabbitmq.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:Direct模式
 *Date:2018-11-20 11:03
 */
@Component
public class MsgReceiver1 {
    @RabbitListener(queues = "queue")
    public void process(String str)
    {
        System.out.println("Receive: "+str);
    }
}
