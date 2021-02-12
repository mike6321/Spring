package me.choi.springcorereview;

import me.choi.springcorereview.member.Grade;
import me.choi.springcorereview.member.Member;
import me.choi.springcorereview.member.MemberService;
import me.choi.springcorereview.order.Order;
import me.choi.springcorereview.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:24 오후
 */
public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);
        MemberService memberService = applicationContext.getBean(MemberService.class);

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println(order);

    }
}
