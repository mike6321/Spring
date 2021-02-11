package me.choi.springcorereview.member;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:44 오후
 */
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
