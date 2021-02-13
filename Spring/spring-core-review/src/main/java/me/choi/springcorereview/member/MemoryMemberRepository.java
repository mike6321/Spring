package me.choi.springcorereview.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:33 오후
 */
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
