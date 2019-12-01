package me.choi.springinitapplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener  {
/*
* 어떠한 빈에 생성자가 한개이고  파라미터가 빈 인 경우 스프링이 알아서 주입시켜준다.
* */


    public SampleListener(ApplicationArguments arguments) {
        System.out.println("foo : "+arguments.containsOption("foo"));
        System.out.println("bar: "+arguments.containsOption("bar"));
    }


}
