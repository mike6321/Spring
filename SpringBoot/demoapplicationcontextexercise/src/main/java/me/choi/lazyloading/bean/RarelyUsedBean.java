package me.choi.lazyloading.bean;

import javax.annotation.PostConstruct;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/05
 * Time : 7:07 오후
 */
public class RarelyUsedBean {

    @PostConstruct
    public void initialize() {
        System.out.println("RarelyUsedBean initializing");
    }

    public void doSomething() {
        System.out.println("RarelyUsedBean method being called");
    }
}
