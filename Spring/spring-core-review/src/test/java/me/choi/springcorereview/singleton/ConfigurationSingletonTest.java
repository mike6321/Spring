package me.choi.springcorereview.singleton;

import me.choi.springcorereview.AppConfig;
import me.choi.springcorereview.member.MemberRepository;
import me.choi.springcorereview.member.MemberServiceImpl;
import me.choi.springcorereview.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * 현재 AppConfig의 코드를 보면 조금 이상하다.
 *     @Bean
 *     public MemberService memberService() {
 *         return new MemberServiceImpl(memberRepository());
 *     }
 *     @Bean
 *     public OrderService orderService() {
 *         return new OrderServiceImpl(memberRepository(), discountPolicy());
 *     }
 *     @Bean
 *     public MemoryMemberRepository memberRepository() {
 *         return new MemoryMemberRepository();
 *     }
 *
 * MemberService에도 memberRepository를 호출하면서 MemoryMemberRepository 인스턴스가 생성되고
 * OrderService에도 memberRepository를 호출하면서 MemoryMemberRepository 인스턴스가 생성된다.
 *
 * "인스턴스를 두번 생성하였기 때문에 싱글톤이 깨지는게 정상아닐까?"
 *
 * Time : 3:00 오전
 */
public class ConfigurationSingletonTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void configurationTest() {
        MemberServiceImpl memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository);
        /**
         * 헐 똑같네?
         * */
    }
    @Test
    void notConfigurationTest() {
        MemberServiceImpl memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        assertThat(memberRepository1).isNotSameAs(memberRepository2);
        assertThat(memberRepository1).isNotSameAs(memberRepository);
    }
}
