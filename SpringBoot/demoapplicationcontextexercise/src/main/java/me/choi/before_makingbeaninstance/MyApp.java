package me.choi.before_makingbeaninstance;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 9:49 오후
 */
public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                                = new AnnotationConfigApplicationContext(Config.class);

//        MyBean myBean = context.getBean("myBean", MyBean.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.doSomething();

    }
}
