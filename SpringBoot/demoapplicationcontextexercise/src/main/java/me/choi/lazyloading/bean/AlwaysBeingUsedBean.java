package me.choi.lazyloading.bean;

import javax.annotation.PostConstruct;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/05
 * Time : 7:06 오후
 */
public class AlwaysBeingUsedBean {

    @PostConstruct
    public void init() {
        System.out.println("AlwaysBeingUsedBean initializing");
    }
}
