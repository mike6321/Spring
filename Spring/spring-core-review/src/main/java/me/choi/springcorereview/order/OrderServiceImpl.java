package me.choi.springcorereview.order;

import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.member.Member;
import me.choi.springcorereview.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:13 오후
 */
@Component
public class OrderServiceImpl implements OrderService{

//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    // TODO: [필드주입] junwoochoi 2021/02/13 7:51 오후
    /**
     * 필드주입 Field injection is not recommended
     * 이라고 인텔리제이가 알려준다.
     *
     * 왜냐면 테스트하기가 어렵기 떄문이다.
     * OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
     * orderServiceImpl.createOrder(...);
     * -> NPE가 발생한다.
     * 필드주입은 원하는 인스턴스를 설정하는 부분이 없기떄문에 테스트를 할 방법이 없다.
     * 이를 방지하기 위해서 setter를 열어야한다. 클라이언트
     *
     *
     * */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // TODO: [일반 메서드 주입] junwoochoi 2021/02/13 8:10 오후
    /**
     * 일반적으로 잘 사용하지 않는다.
     * */
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    // TODO: [setter 주입] junwoochoi 2021/02/13 7:33 오후
    /**
     * 스프링컨테이너는 OrderServiceImpl 과 같은 스프링 빈을 다 등록한다.
     * 그리고 연관관계를 자동으로 주입한다.
     * 여기서 연관관계란 @Autowired를 의미한다.
     * */
//    @Autowired
//    private void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("여기타냐?");
//        System.out.println("MemberRepository : " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
//    private void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("여기타냐?");
//        System.out.println("DiscountPolicy : " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    // TODO: [생성자가 하나일 땐 @Autowired 생략가능] junwoochoi 2021/02/13 7:14 오후
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // TODO: 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}