package me.choi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);


        MyBean bean = context.getBean(MyBean.class);

        System.out.println(bean);
    }
}
