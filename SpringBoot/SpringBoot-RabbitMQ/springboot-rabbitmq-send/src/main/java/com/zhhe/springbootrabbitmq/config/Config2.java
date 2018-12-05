package com.zhhe.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;


/*
 *Author:ZouHeng
 *Des:Topic
 *Date:2018-11-20 11:29
 */
@Configuration
public class Config2 {

    @Bean(name = "message")
    public Queue queueMessage()
    {
        return new Queue("topic.message");
    }

    @Bean(name = "messages")
    public Queue queueMessages()
    {
        return new Queue("topic.messages");
    }

    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage,TopicExchange exchange)
    {
        /*
        参数1：Queue
        参数2：Exchange
        参数3：routingKey
         */
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
