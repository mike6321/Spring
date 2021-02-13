package me.choi.springcorereview.autowired;

import me.choi.springcorereview.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:15 오후
 */
public class AutowiredTest {
    @Test
    void AutoWiredOption() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // TODO: @Autowired(required = false) 를 설정하면 메서드 자체가 호출이 안된다.  
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("noBean1" + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("noBean2 : " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("noBean3 : " + member);
        }
    }
}
