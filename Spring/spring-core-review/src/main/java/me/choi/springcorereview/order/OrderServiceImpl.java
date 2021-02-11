package me.choi.springcorereview.order;

import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.discount.FixDiscountPolicy;
import me.choi.springcorereview.discount.RateDiscountPolicy;
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
    // TODO: 2021/02/11 정률할인정책 변경
    /**
     * 클라이언트 소스 코드 수정 불가피
     * 추상에도 의존 구체에도 의존
     * DIP 위반 (추상에만 의존하지 않았음)
     * */
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
