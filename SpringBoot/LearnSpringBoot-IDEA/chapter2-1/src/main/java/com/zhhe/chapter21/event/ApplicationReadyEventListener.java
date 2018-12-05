package com.zhhe.chapter21.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-23 9:53
 */
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>
{
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent)
    {
        System.out.println("......ApplicationReadyEvent......");
    }
}
