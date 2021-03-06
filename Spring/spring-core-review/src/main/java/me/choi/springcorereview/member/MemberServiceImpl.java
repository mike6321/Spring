package me.choi.springcorereview.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:37 오후
 */
@Component
public class MemberServiceImpl implements MemberService{
    // TODO: 2021/02/11 실제 할당하는 부분이 구현체를 알고있어야 한다. 
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // TODO: 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
