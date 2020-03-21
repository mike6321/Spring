package me.choi.dynamically_registerbeans.using_beandefinitionregistrypostprocessor;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/21
 * Time : 6:59 오후
 */
public class MyBean {
    private String strProp;

    public void setStrProp(String strProp) {
        this.strProp = strProp;
    }

    public void doSomething() {
        System.out.println("from myBean :: "+strProp);
    }
}
