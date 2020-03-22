package me.choi.dynamically_registerbeans.using_genericbeandefinition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.Assert;

import java.util.Date;

public class GenericBeanDefinitionExample {
    public static void main(String[] args) {
        DefaultListableBeanFactory context = new DefaultListableBeanFactory();

        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(MyBean.class);


        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("date", new Date());

        gbd.setPropertyValues(mpv);
        context.registerBeanDefinition("myBeanName", gbd);

        //MyBean bean = context.getBean(MyBean.class);
        MyBean bean = context.getBean("myBeanName",MyBean.class);
        bean.doSomething();

    }
}
