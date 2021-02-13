package me.choi.springcorereview.scan;

import me.choi.springcorereview.AutoAppConfig;
import me.choi.springcorereview.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

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
    }
}
