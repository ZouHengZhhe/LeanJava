package com.zhhe.springbootrabbitmq;

import com.rabbitmq.client.*;
import com.zhhe.springbootrabbitmq.chapter1.HelloReceiver;
import com.zhhe.springbootrabbitmq.chapter1.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests
{
    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloReceiver helloReceiver;

    private final static String QUEUE_NAME = "MQTT_Queue";

    @Test
    public void contextLoads() throws IOException, TimeoutException
    {
//        helloSender.send("123456");


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException
            {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

}
