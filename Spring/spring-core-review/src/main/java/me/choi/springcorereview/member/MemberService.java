package me.choi.springcorereview.member;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:36 오후
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
