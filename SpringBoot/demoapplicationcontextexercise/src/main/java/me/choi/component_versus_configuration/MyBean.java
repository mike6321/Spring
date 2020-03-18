package me.choi.component_versus_configuration;

import java.util.Date;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 9:29 오후
 */
public class MyBean {
    private Date date;

    public void doSomething() {
        System.out.println("from my bean , date :: "+date);
    }

    public void setDate (Date date) {
        this.date = date;
    }
}
