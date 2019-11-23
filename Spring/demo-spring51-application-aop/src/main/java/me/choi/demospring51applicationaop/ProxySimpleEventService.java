package me.choi.demospring51applicationaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProxySimpleEventService implements EventService{

    @Autowired
    //SimpleEventService simpleEventService;
    EventService simpleEventService;

    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();

        simpleEventService.createEvent();

        System.out.println(System.currentTimeMillis()-begin);
    }

    @Override
    public void publicEvnet() {
        long begin = System.currentTimeMillis();

        simpleEventService.publicEvnet();

        System.out.println(System.currentTimeMillis()-begin);

    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
        System.out.println("Delete an evnet");
    }
}
