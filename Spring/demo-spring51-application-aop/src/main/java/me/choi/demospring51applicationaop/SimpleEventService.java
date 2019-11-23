package me.choi.demospring51applicationaop;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{
    @PerLogging
    @Override
    public void createEvent() {
        //long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Created an event");
        //System.out.println(System.currentTimeMillis()-begin);

    }
    @PerLogging
    @Override
    public void publicEvnet() {
        //long begin = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Published an evnet");
        //System.out.println(System.currentTimeMillis()-begin);
    }

    @Override
    public void deleteEvent() {
        System.out.println("Delete an evnet");
    }

}
