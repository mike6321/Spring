package me.choi.using_genericbeandefinition;

import java.util.Date;

public class MyBean {
    private Date date;

    public void doSomething() {
        System.out.println("현재 시간 :: "+date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
