package me.choi.dynamically_registerbeans.using_beanfactorypostprocessor;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/20
 * Time : 12:11 오전
 */
public class MyBean {
    private String strProp;

    public void setStrProp(String strProp) {
        this.strProp = strProp;
    }

    public void doSomething() {
        System.out.println("from myBean :: "+ strProp);
    }
}

