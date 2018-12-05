package com.zhhe.chapter21.event;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-11-23 9:50
 */
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>
{

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent)
    {
        System.out.println("......ApplicationPreparedEvent......");
    }
}
