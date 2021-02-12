package me.choi.springcorereview.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:36 오전
 */
public class StatefulServiceTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void statefulServiceSingleton() {
        StatefulService statefulService1 = applicationContext.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = applicationContext.getBean("statefulService", StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : B사용자가 10000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
        assertThat(userAPrice).isEqualTo(10000);
        assertThat(userBPrice).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
