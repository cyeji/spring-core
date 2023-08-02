package hello.core.v1.discount;

import hello.core.v1.member.Grade;
import hello.core.v1.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;

    }
}
