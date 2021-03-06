package me.choi.demospring51applicationeventpublisher;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler { //implements ApplicationListener<MyEvent> {

    @EventListener
    //@Order(Ordered.LOWEST_PRECEDENCE)
    @Async
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다 데이터는"+myEvent.getData());
    }

    @EventListener
    @Async
    public void handle(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
        //event.getApplicationContext();
    }

    @EventListener
    @Async
    public void handle(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
        //event.getApplicationContext();
    }
//    @Override
//    public void onApplicationEvent(MyEvent myEvent) {
//        System.out.println("이벤트 받았다 데이터는"+myEvent.getData());
//    }
}
