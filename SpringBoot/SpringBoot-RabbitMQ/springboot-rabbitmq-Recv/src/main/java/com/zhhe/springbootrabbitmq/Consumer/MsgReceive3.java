package com.zhhe.springbootrabbitmq.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:fanout
 *Date:2018-11-20 11:41
 */
@Component
public class MsgReceive3 {
    @RabbitListener(queues = "fanout.A")
    public void process1(String str)
    {
        System.out.println("ReceiveA: "+str);
    }

    @RabbitListener(queues = "fanout.B")
    public void process2(String str)
    {
        System.out.println("ReceiveB: "+str);
    }


    @RabbitListener(queues = "fanout.C")
    public void process3(String str)
    {
        System.out.println("ReceiveC: "+str);
    }
}
