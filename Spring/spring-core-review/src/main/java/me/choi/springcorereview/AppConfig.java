package me.choi.springcorereview;

import me.choi.springcorereview.discount.FixDiscountPolicy;
import me.choi.springcorereview.member.MemberService;
import me.choi.springcorereview.member.MemberServiceImpl;
import me.choi.springcorereview.member.MemoryMemberRepository;
import me.choi.springcorereview.order.OrderService;
import me.choi.springcorereview.order.OrderServiceImpl;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:49 오후
 */
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
