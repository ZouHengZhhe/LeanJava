package com.zhhe.chapter21.event;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-23 9:52
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>
{
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent)
    {
        System.out.println("......ApplicationStartedEvent......");
    }
}
