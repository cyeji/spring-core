package hello.core.v1.discount;

import hello.core.v1.annotation.MainDiscountPolicy;
import hello.core.v1.member.Grade;
import hello.core.v1.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price / 10 : 0;
    }
}
