package me.choi.springcorereview.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment : 스프링은 의존관계 주입이 완료되면 스프링 빈에게 콜백 메서드를 통해서 초기화 시점을 알려주는 다양한 기능을 제공 (소멸 콜백 또한 제공)
 * 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸 전 콜백 -> 스프링 종료
 *
 * 초기화 콜백 : 빈이 생성되고 의존관계 주입이 완료된 후 호출
 * 소멸전 콜백 : 빈이 소멸되기 직전에 호출
 * Time : 11:22 오전
 */
public class BeanLifeCycleTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

    @Test
    public void lifeCycleTest() {
        NetworkClient client = applicationContext.getBean(NetworkClient.class);
        applicationContext.close();
    }
    /**
     * 생성자 호출, url null
     * connect null
     * call nullmessage = 초기화 연결 메세지
     *
     * 인스턴스 생성 당시에는 setter 가 호출되지 않으므로 null이 되는것이 맞다.
     * */

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://spring-review-study.com");
            return networkClient;
        }
    }
}
