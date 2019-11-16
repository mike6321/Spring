package me.choi.demospring51applicationeventpublisher;

import org.springframework.context.ApplicationEvent;

/*
* 4.2에 와서는 더이사 ApplicationEvent를 상속받을 필요가 없다.
* 가장 스프링이 추구하는 pojo 기반의 프로그래밍이다.
* */
public class MyEvent {//extends ApplicationEvent {

    private int data;
    private Object source;

    public MyEvent(Object source, int data) {
        //super(source);
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}
