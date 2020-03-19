package me.choi.dynamically_registerbeans.using_beandefinitionbuilder;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/19
 * Time : 10:50 오후
 */
public class MyBean {
    private String str;

    public void setStr (String str) {
        this.str = str;
    }

    public void doSomething() {
        System.out.println("from MyBean :: "+str);
    }
}
