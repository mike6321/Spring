package me.choi.component_versus_configuration;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Date;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 9:28 오후
 */
public class GenericBeanDefinitionExample {
    public static void main(String[] args) {
        DefaultListableBeanFactory cotext =
                new DefaultListableBeanFactory();

        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(MyBean.class);

        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("date", new Date());

        gbd.setPropertyValues(mpv);

        cotext.registerBeanDefinition("myBeanName", gbd);

        MyBean myBean = cotext.getBean(MyBean.class);
        myBean.doSomething();
    }
}
