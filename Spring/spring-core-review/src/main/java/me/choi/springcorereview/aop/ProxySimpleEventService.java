package me.choi.springcorereview.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment : Proxy
 * Time : 8:28 오후
 */
@Primary
@Service
public class ProxySimpleEventService {//implements EventService{

    @Autowired
    EventService simpleEventService;

    // TODO: AOP Proxy 생성 2021/03/01 8:33 오후
    /**
     * 프록시를 생성해도 중복된 코드가 생성되었음
     * */
//    @Override
//    public void createEvent() {
//        long begin = System.currentTimeMillis();
//        simpleEventService.createEvent();
//        System.out.println(System.currentTimeMillis() - begin);
//    }
//
//    @Override
//    public void publishEvent() {
//        long begin = System.currentTimeMillis();
//        simpleEventService.publishEvent();
//        System.out.println(System.currentTimeMillis() - begin);
//    }
//
//    @Override
//    public void deleteEvent() {
//        simpleEventService.deleteEvent();
//    }
}
