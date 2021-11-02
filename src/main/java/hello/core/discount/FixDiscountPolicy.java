package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//등급에 따른 할인 적용 여부
@Component
//@Qualifier("fixDiscountPolicy")//해당 이름으로 나중에 똑같이 호출하여 사용할 수 있다.
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;//1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
