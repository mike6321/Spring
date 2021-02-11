package me.choi.springcorereview;

import me.choi.springcorereview.member.Grade;
import me.choi.springcorereview.member.Member;
import me.choi.springcorereview.member.MemberService;
import me.choi.springcorereview.member.MemberServiceImpl;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:43 오후
 */
public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("find Member = " + findMember.getName());
        System.out.println("new Member = " + member.getName());
    }
}
