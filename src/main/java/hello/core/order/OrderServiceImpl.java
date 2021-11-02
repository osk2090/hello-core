package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;//member를 가져오는 용도
    private final DiscountPolicy discountPolicy;//할인 정책 용도

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//member를 찾아서
        int discountPrice = discountPolicy.discount(member, itemPrice);//그 member와 회원 등급에 따른 할인금액을 받는다.

        return new Order(memberId, itemName, itemPrice, discountPrice);//새 주문을 생성하여 memberId,상품이름,상품가격,할인금액을 리턴해준다.
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
