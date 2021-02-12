package me.choi.springcorereview.beanfind;

import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.discount.FixDiscountPolicy;
import me.choi.springcorereview.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:17 오전
 */
public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상이면 중복 오류가 발생")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상이면 BeanName을 지정하")
    void findBeanByParentTypeBeanName() {
        DiscountPolicy rateDisCountPolicy = applicationContext.getBean("rateDisCountPolicy", DiscountPolicy.class);
        assertThat(rateDisCountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위타입으로 조회")
    void findBeanSubType() {
        RateDiscountPolicy bean = applicationContext.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(DiscountPolicy.class);
    }

    /**
     * key = rateDisCountPolicy value = me.choi.springcorereview.discount.RateDiscountPolicy@6c61a903
     * key = fixDiscountPoilicy value = me.choi.springcorereview.discount.FixDiscountPolicy@658c5a19
     * */
    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("Object 타입으로 모두 조회하기")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDisCountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPoilicy() {
            return new FixDiscountPolicy();
        }
    }
}
