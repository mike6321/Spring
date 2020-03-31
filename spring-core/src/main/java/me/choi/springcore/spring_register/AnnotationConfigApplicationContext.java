package me.choi.springcore.spring_register;



import org.springframework.util.Assert;

import java.util.Collections;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/31
 * Time : 10:40 오후
 */
public class AnnotationConfigApplicationContext {

    //private final AnnotatedBeanDefinitionReader reader;
    
    AnnotationConfigApplicationContext(Class<?> componentClasses) {
        register(componentClasses);
    }

    private void register(Class<?> componentClasses) {
        Assert.notEmpty(Collections.singleton(componentClasses), "123");


}
