package me.choi.before_makingbeaninstance;

import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 9:49 오후
 */
public class MyBean {

    public void doSomething() {
        System.out.println("나는"+ this.getClass() + "입니다...!!");
    }

}
