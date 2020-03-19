package me.choi.dynamically_registerbeans.using_beandefinitionbuilder;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/19
 * Time : 10:51 오후
 */
public class BeanDefinitionBuilderExample {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder bd = BeanDefinitionBuilder.rootBeanDefinition(MyBean.class)
                                                        .addPropertyValue("str", "myStringValue");

        beanFactory.registerBeanDefinition("myBean", bd.getBeanDefinition());

        MyBean bean = beanFactory.getBean(MyBean.class);
        bean.doSomething();
    }
}
