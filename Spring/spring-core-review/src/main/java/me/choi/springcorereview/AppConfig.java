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
 */
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // TODO: 이것만 고치면 끝!  
    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
