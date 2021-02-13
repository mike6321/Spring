package me.choi.springcorereview;

import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.discount.RateDiscountPolicy;
import me.choi.springcorereview.member.MemberService;
import me.choi.springcorereview.member.MemberServiceImpl;
import me.choi.springcorereview.member.MemoryMemberRepository;
import me.choi.springcorereview.order.OrderService;
import me.choi.springcorereview.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:49 오후
 *
 * 예상순서
 * 1. AppConfig.memberService
 * 2. AppConfig.memberRepository (1)
 * 3. AppConfig.memberRepository (2)
 * 4. AppConfig.orderService
 * 5. AppConfig.memberRepository (3)
 *
 * Real 실행순서
 * 1. AppConfig.memberService
 * 2. AppConfig.memberRepository
 * 3. AppConfig.orderService
 * 한 번만 호출한다.
 */
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
