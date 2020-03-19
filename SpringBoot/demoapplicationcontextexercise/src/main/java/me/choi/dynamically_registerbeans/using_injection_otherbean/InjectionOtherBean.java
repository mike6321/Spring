package me.choi.dynamically_registerbeans.using_injection_otherbean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/19
 * Time : 11:56 오후
 */
public class InjectionOtherBean {

    public static void main(String[] args) {
        DefaultListableBeanFactory context = new DefaultListableBeanFactory();


        /*************************OtherBean Class*************************/
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(OtherBean.class);
        context.registerBeanDefinition("other", gbd);
        /*************************OtherBean Class*************************/


        /*************************MyBean Class*************************/
        GenericBeanDefinition gbd2 = new GenericBeanDefinition();
        gbd2.setBeanClass(MyBean.class);

        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.addPropertyValue("otherBean", context.getBean("other"));

        gbd2.setPropertyValues(mpv);
        context.registerBeanDefinition("myBean", gbd2);
        /*************************MyBean Class*************************/

        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();

        OtherBean bean1 = context.getBean(OtherBean.class);
        bean1.doSomething();
    }
}
