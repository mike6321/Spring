package me.choi.springcorereview.order;

import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.discount.FixDiscountPolicy;
import me.choi.springcorereview.member.Member;
import me.choi.springcorereview.member.MemberRepository;
import me.choi.springcorereview.member.MemoryMemberRepository;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:13 오후
 */
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
