package me.choi.springcorereview.autowired;

import me.choi.springcorereview.AutoAppConfig;
import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.member.Grade;
import me.choi.springcorereview.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment : 전략패턴 적
 * Time : 12:48 오전
 */
public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        //given
        DiscountService discountService = applicationContext.getBean(DiscountService.class);
        //when
        Member member = new Member(1l, "junwoo", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        //then
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        //when
        int discountPrice2 = discountService.discount(member, 20000, "rateDiscountPolicy");
        //then
        assertThat(discountPrice2).isEqualTo(2000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;
        /**
         * policyMap = {fixDiscountPolicy=me.choi.springcorereview.discount.FixDiscountPolicy@282cb7c7, rateDiscountPolicy=me.choi.springcorereview.discount.RateDiscountPolicy@7d898981}
         * policies = [me.choi.springcorereview.discount.FixDiscountPolicy@282cb7c7, me.choi.springcorereview.discount.RateDiscountPolicy@7d898981]
         *
         * Primary, Qualifier를 사용하더라도
         * todo 나머지 의존관계 있는 구체 클래스도 Bean은 생성이 되는구나!!!
         * */
        // TODO: 전략패턴 적용
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            return discountPolicy.discount(member, price);
        }
    }
}
