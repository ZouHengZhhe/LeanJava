package com.zhhe.springbootrabbitmq.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/*
 *Author:ZouHeng
 *Des:消息的消费者（接收端）
 *Date:2018-11-20 10:47
 */
public class MsgReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        logger.info("接收处理队列A当中的消息： " + content);
    }

}
