package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void test_case_1(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertEquals(1000,discount);
    }
    @Test
    @DisplayName("일반인은 0% 할인이 적용되어야 한다")
    void test_case_2(){
        //given
        Member member = new Member(1L,"member", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertEquals(0,discount);
    }

}