package me.choi.springinitapplication;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
/*
* ApplicationStartingEvent
* 애플리케이션 구동시 맨 처음에 작동하는 이벤트로서
* 이 이벤트가 작동할 시에는 applicaioncontext가 만들어지지 않았다.
* */
public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("==============================");
        System.out.println("Application is Starting...");
        System.out.println("==============================");
    }
}
