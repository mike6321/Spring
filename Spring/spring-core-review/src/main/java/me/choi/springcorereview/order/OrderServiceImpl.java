package me.choi.springcorereview.order;

import me.choi.springcorereview.annotation.MainDiscountPolicy;
import me.choi.springcorereview.discount.DiscountPolicy;
import me.choi.springcorereview.member.Member;
import me.choi.springcorereview.member.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:13 오후
 */
// TODO: [Primary, Qualifier의 의문점] junwoochoi 2021/02/14 12:11 오전
/**
 * 그래 좋다 편리하게 두개의 의존성이 중복될떄 어노테이선 하나만으로 편리하게 할 수 있다는 점
 * 허나 저렇게 지정을 해버리면 지정을 안한것은 못쓰지 않을까?
 *
 * FixDisCountPolicy를 Primary로 지정하면
 * 나머지 RateDiscountPolicy는 못쓰게 되니깐...
 *
 * 생성자를 똑같은 것을 두개 만들 수 는 없기에...
 *
 * InteliJ Compile error Message
 * 'OrderServiceImpl(MemberRepository, DiscountPolicy)' is already defined in 'me.choi.springcorereview.order.OrderServiceImpl'
 * */

@Component
//@RequiredArgsConstructor
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
     * 이를 방지하기 위해서 setter를 열어야한다. 클라이언트 코드에 대한 수정이 불가피
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

//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        System.out.println("1. OrderServiceImpl");
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // TODO: [생성자가 하나일 땐 @Autowired 생략가능] junwoochoi 2021/02/13 7:14 오후
    // TODO: [DiscountPolicy를 구현체인 FixDiscountPolicy, FixDiscountPolicy 두개가 빈으로 등록되어 있을 때] junwoochoi 2021/02/13 11:35 오후
    /**
     * 1. 파라미터 명을 구현 대상으로 설정
     * (MemberRepository memberRepository, DiscountPolicy discountPolicy) -> (MemberRepository memberRepository, DiscountPolicy fixDiscountPolicy)
     * todo : 파라미터 명을 구현 대상으로 설정
     * */
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy fixDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = fixDiscountPolicy;
//    }
    /**
     * 2. Qualifier 설정
     * @Qualifier("mainDiscountPolicy")
     * public class FixDiscountPolicy implements DiscountPolicy{
     * }
     * todo : Qualifier
     * todo : Qualifier - Refactoring with Annotaion
     * */
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 2. Primary 설정
     * @Qualifier("mainDiscountPolicy")
     * @Primary
     * public class FixDiscountPolicy implements DiscountPolicy{
     * }
     * todo : Primary
     * */
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

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