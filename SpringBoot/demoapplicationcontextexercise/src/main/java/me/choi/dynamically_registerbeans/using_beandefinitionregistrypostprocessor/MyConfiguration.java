package me.choi.dynamically_registerbeans.using_beandefinitionregistrypostprocessor;

import me.choi.dynamically_registerbeans.using_beanfactorypostprocessor.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/21
 * Time : 6:57 오후
 */
public class MyConfiguration implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(MyBean.class);
        gbd.getPropertyValues().add("strProp", "my String property");
        registry.registerBeanDefinition("myBeanName", gbd);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
