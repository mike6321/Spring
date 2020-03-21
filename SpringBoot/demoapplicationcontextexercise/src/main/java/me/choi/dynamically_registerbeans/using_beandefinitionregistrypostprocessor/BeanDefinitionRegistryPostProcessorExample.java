package me.choi.dynamically_registerbeans.using_beandefinitionregistrypostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/21
 * Time : 7:01 오후
 */
public class BeanDefinitionRegistryPostProcessorExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                            new AnnotationConfigApplicationContext(MyConfig.class);

        MyBean myBeanName = (MyBean) context.getBean("myBeanName");

        myBeanName.doSomething();
    }
}
