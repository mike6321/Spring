package me.choi.springcorereview.aop;

import org.springframework.stereotype.Service;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment : RealSubject
 * Time : 8:18 오후
 */
@Service
public class SimpleEventService implements EventService{
    @Override
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("이벤트 생성");
    }

    @Override
    public void publishEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("이벤트 발행");
    }
}
