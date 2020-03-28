package me.aop.inflearn_aop;

import org.springframework.stereotype.Service;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/28
 * Time : 11:48 오후
 */
@Service
public class SimpleEventService implements EventService {
    @Override
    public void createEvent() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Create an Event");
    }

    @Override
    public void publishEvent() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Published an Event");
    }

    @Override
    public void deleteEvent() {
        System.out.println("Delete an Event");
    }
}
