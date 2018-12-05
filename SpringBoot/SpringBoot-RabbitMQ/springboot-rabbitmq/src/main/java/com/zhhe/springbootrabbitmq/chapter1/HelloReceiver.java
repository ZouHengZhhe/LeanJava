package com.zhhe.springbootrabbitmq.chapter1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-26 15:32
 */
@Component
@RabbitListener(queues = "MQTT_Queue")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}
