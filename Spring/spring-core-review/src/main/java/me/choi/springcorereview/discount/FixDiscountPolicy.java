package me.choi.springcorereview.discount;

import me.choi.springcorereview.annotation.MainDiscountPolicy;
import me.choi.springcorereview.member.Grade;
import me.choi.springcorereview.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:08 오후
 */
// TODO: FixDisCountPolicy도 빈으로 등록
@Component
//@Qualifier("mainDiscountPolicy")
//@Primary
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
