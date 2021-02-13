package me.choi.springcorereview.scan;

import me.choi.springcorereview.AutoAppConfig;
import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.member.MemberRepository;
import me.choi.springcorereview.member.MemberService;
import me.choi.springcorereview.order.OrderService;
import me.choi.springcorereview.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:42 오전
 */
public class AutoAppConfigTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    /**
     * 11:44:09.686 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Applications/WorkingDirectory/repository/Spring/Spring/spring-core-review/out/production/classes/me/choi/springcorereview/discount/RateDiscountPolicy.class]
     * 11:44:09.688 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Applications/WorkingDirectory/repository/Spring/Spring/spring-core-review/out/production/classes/me/choi/springcorereview/member/MemberServiceImpl.class]
     * 11:44:09.688 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Applications/WorkingDirectory/repository/Spring/Spring/spring-core-review/out/production/classes/me/choi/springcorereview/member/MemoryMemberRepository.class]
     * 11:44:09.689 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Applications/WorkingDirectory/repository/Spring/Spring/spring-core-review/out/production/classes/me/choi/springcorereview/order/OrderServiceImpl.class]
     * */
    @Test
    void basicScan() {
        MemberService memberService = applicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        //basePackages = "me.choi.springcorereview.member"
//        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(OrderService.class));
    }

    @Test
    void skipAutoWired() {
        //현재 OrderServiceImpl 을 생략한 상태
        OrderServiceImpl bean1 = applicationContext.getBean(OrderServiceImpl.class);
        assertThat(bean1).isNotNull();

        MemberRepository bean2 = applicationContext.getBean(MemberRepository.class);
        System.out.println(bean2);
        assertThat(bean2).isNotNull();

        DiscountPolicy bean3 = applicationContext.getBean(DiscountPolicy.class);
        assertThat(bean3).isNotNull();
    }
}
