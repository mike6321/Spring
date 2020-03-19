package me.choi.dynamically_registerbeans.using_beanfactorypostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/20
 * Time : 12:15 오전
 */
public class BeanFactoryPostProcessorExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                                new AnnotationConfigApplicationContext(MyConfig.class);

        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();
    }
}
