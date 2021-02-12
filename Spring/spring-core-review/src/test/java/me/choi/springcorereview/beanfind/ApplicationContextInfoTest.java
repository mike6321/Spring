package me.choi.springcorereview.beanfind;

import me.choi.springcorereview.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:11 오후
 */
public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * bean Name :: org.springframework.context.annotation.internalConfigurationAnnotationProcessor, Object :: org.springframework.context.annotation.ConfigurationClassPostProcessor@6d7fc27
     * bean Name :: org.springframework.context.annotation.internalAutowiredAnnotationProcessor, Object :: org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@45ac5f9b
     * bean Name :: org.springframework.context.annotation.internalCommonAnnotationProcessor, Object :: org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@135606db
     * bean Name :: org.springframework.context.event.internalEventListenerProcessor, Object :: org.springframework.context.event.EventListenerMethodProcessor@518caac3
     * bean Name :: org.springframework.context.event.internalEventListenerFactory, Object :: org.springframework.context.event.DefaultEventListenerFactory@68034211
     * bean Name :: appConfig, Object :: me.choi.springcorereview.AppConfig$$EnhancerBySpringCGLIB$$96fc528c@4f74980d
     * bean Name :: memberService, Object :: me.choi.springcorereview.member.MemberServiceImpl@6c372fe6
     * bean Name :: orderService, Object :: me.choi.springcorereview.order.OrderServiceImpl@58594a11
     * bean Name :: memberRepository, Object :: me.choi.springcorereview.member.MemoryMemberRepository@2a3888c1
     * bean Name :: discountPolicy, Object :: me.choi.springcorereview.discount.RateDiscountPolicy@4167d97b
     * */
    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("bean Name :: " + beanDefinitionName + ", Object :: " + bean);
        }
    }

    /**
     * bean Name :: appConfig, Object :: me.choi.springcorereview.AppConfig$$EnhancerBySpringCGLIB$$96fc528c@6d7fc27
     * bean Name :: memberService, Object :: me.choi.springcorereview.member.MemberServiceImpl@45ac5f9b
     * bean Name :: orderService, Object :: me.choi.springcorereview.order.OrderServiceImpl@135606db
     * bean Name :: memberRepository, Object :: me.choi.springcorereview.member.MemoryMemberRepository@518caac3
     * bean Name :: discountPolicy, Object :: me.choi.springcorereview.discount.RateDiscountPolicy@68034211
     *
     * bean Name :: org.springframework.context.annotation.internalConfigurationAnnotationProcessor, Object :: org.springframework.context.annotation.ConfigurationClassPostProcessor@6d7fc27
     * bean Name :: org.springframework.context.annotation.internalAutowiredAnnotationProcessor, Object :: org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@45ac5f9b
     * bean Name :: org.springframework.context.annotation.internalCommonAnnotationProcessor, Object :: org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@135606db
     * bean Name :: org.springframework.context.event.internalEventListenerProcessor, Object :: org.springframework.context.event.EventListenerMethodProcessor@518caac3
     * bean Name :: org.springframework.context.event.internalEventListenerFactory, Object :: org.springframework.context.event.DefaultEventListenerFactory@68034211
     * */
    @Test
    @DisplayName("Application 빈 출력")
    void findApplicationBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //Bean에 대한 메터정보 출력
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("bean Name :: " + beanDefinitionName + ", Object :: " + bean);
            }

            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("bean Name :: " + beanDefinitionName + ", Object :: " + bean);
            }
        }
    }
}
