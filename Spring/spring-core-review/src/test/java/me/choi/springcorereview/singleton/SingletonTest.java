package me.choi.springcorereview.singleton;

import me.choi.springcorereview.AppConfig;
import me.choi.springcorereview.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:45 오전
 */
public class SingletonTest {

    @Test
    @DisplayName("스프링을 배제한 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출될 떄 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출될 떄 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 : " + memberService2);

        /**
         * memberService1 : me.choi.springcorereview.member.MemberServiceImpl@4b9e255
         * memberService2 : me.choi.springcorereview.member.MemberServiceImpl@5e57643e
         *
         * 주소 값이 다름을 확인
         * 호출할 때 마다 새로운 인스턴스를 생성
         * */

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = applicationContext.getBean("memberService", MemberService.class);
        MemberService memberService2 = applicationContext.getBean("memberService", MemberService.class);

//        assertThat(memberService1).isNotSameAs(memberService2);
        assertThat(memberService1).isSameAs(memberService2);
    }
}
