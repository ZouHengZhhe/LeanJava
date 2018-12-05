package com.zhhe.springbootmqtt.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-26 16:36
 */
public class MqttRecv
{

    public static void main(String[] args)
    {
        MqttRecv mqttRecv = new MqttRecv();
        try
        {
            mqttRecv.recv();
        } catch (MqttException e)
        {
            e.printStackTrace();
        }
    }

    public void recv() throws MqttException
    {
        MqttClient client=new MqttClient("tcp://localhost:1883", "zhhe");
        MqttConnectOptions options=new MqttConnectOptions();
        options.setCleanSession(false);

        client.setCallback(new MqttCallback()
        {
            @Override
            public void connectionLost(Throwable throwable)
            {
                System.out.println("connectionLost!");
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception
            {
                System.out.println("Recv : "+message);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken)
            {

            }
        });

        client.connect(options);
        client.subscribe("test");
    }
}
