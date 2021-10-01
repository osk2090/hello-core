package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//등급에 따른 할인 적용 여부
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
