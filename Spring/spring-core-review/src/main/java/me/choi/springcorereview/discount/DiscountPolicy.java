package me.choi.springcorereview.discount;

import me.choi.springcorereview.member.Member;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:07 오후
 */
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     * */
    int discount(Member member, int price);
}
