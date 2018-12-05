package com.zhhe.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-20 9:55
 */
@Configuration
public class RabbitConfig1
{
    @Bean
    public Queue queue()
    {
        return new Queue("queue");
    }

}
