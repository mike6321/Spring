package me.choi.springcore.spring_static;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/09
 * Time : 10:12 오후
 */
public abstract class AbstractApplicationContext {

    private static int num;

    static {
       num = 50;
    }
}
