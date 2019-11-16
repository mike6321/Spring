package me.choi.demospring51applicationeventpublisher;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component

public class AnotherHandler {
    @EventListener
    //sequencial일때 순서를 정해주는 방법
    //@Order(Ordered.HIGHEST_PRECEDENCE+2)
    @Async
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another : "+myEvent.getData());
    }
}

