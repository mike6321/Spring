package me.choi.springcorereview.discount;

import me.choi.springcorereview.member.Grade;
import me.choi.springcorereview.member.Member;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:54 오후
 */
@Component
public class RateDiscountPolicy implements DiscountPolicy{
    // TODO: 타입을 기준으로 의존성 주입을 하는데 현재는 RateDiscountPolicy만 Bean으로 등록되어있어서 중복이 일어나지 않는다.  
    // TODO: 허나 FixDiscountPolicy가 Bean으로 등록되면 같은 타입이 두개이기떄문에 의존성 주입에 오류가 일어나지 않을까?  

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
