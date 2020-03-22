package me.choi.dynamically_registerbeans.using_genericapplicationcontext;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 6:37 오후
 */
public class Customizers {
    public static void prototypeScoped(BeanDefinition bd) {
        bd.setScope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE);
    }

    public static void lazy(BeanDefinition bd) {
        bd.setScope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE);
    }

    public static void defaultInitMethod(BeanDefinition bd) {
        bd.setInitMethodName("init");
    }

    public static void defaultDestroyMethod(BeanDefinition bd) {
        bd.setDestroyMethodName("destroy");
    }
}
