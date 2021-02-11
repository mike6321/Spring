package me.choi.springcorereview.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:51 오후
 */
public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}


