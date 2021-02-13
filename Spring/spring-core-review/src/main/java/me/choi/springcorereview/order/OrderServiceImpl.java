package me.choi.springcorereview.order;

import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.member.Member;
import me.choi.springcorereview.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:13 오후
 */
@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // TODO: 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}