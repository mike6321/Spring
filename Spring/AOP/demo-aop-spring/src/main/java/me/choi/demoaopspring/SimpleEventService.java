package me.choi.demoaopspring;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{

    @Override
    public void createEvent() {
        //long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Create an event!");
        //System.out.println("createEvent 실행시간: "+(System.currentTimeMillis()-begin));
    }

    @Override
    public void publishEvent() {
        //long begin = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Published an event!");
        //System.out.println("publishEvent 실행시간: "+(System.currentTimeMillis()-begin));
    }

    @Override
    public void deleteEvent() {
        System.out.println("Delete an event!");
    }
}
