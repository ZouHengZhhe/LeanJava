package com.zhhe.springbootrabbitmq.chapter1;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-26 15:30
 */
@Configuration
public class RabbitConfig {

    public static String queueName="MQTT_Queue";

    @Bean
    public Queue Queue() {
        return new Queue(queueName);
    }

    @Bean
    public FanoutExchange fanoutExchange()
    {
        return new FanoutExchange(queueName);
    }
}
