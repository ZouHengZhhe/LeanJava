package com.zhhe.springbootrabbitmq.chapter1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-26 15:31
 */
@Component
public class HelloSender
{

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg)
    {
        this.rabbitTemplate.convertAndSend(RabbitConfig.queueName, msg);
    }

}