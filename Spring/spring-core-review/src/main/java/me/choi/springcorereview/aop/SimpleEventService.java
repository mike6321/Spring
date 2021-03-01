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

    @PerfLogging
    @Override
    public void createEvent() {
        // TODO: AOP RealSubject 직접 수정 2021/03/01 8:25 오후
//        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("이벤트 생성");

//        System.out.println(System.currentTimeMillis() - begin);
    }

    @PerfLogging
    @Override
    public void publishEvent() {

//        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("이벤트 발행");

//        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        System.out.println("이벤트 삭제");
    }
}
