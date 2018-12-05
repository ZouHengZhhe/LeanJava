package com.zhhe.springbootrabbitmq.Producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-20 10:53
 */
@Component
public class MsgProducer1 {
    @Autowired
    private AmqpTemplate template;

    public void send()
    {
        template.convertAndSend("queue","hello,rabbit!");
    }

    public void send2(String exchangeName,String key,String data)
    {
        template.convertAndSend(exchangeName,key,data);
    }

    public void send3(String exchangeName,String data)
    {
        /*
        第二个参数routingKey将被忽略
         */
        template.convertAndSend(exchangeName,"",data);
    }
}
