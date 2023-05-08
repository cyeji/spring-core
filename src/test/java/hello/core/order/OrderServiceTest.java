package hello.core.order;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

   MemberService memberService;
   OrderService orderService;

   @BeforeEach
   void before(){
       AppConfig appConfig = new AppConfig();
       memberService = appConfig.memberService();;
       orderService = appConfig.orderService();
   }


    @Test
    @DisplayName("createOrder")
    void test_case_1(){
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when
        memberService.join(member);

        // then
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertEquals(1000,order.getDiscountPrice());

    }

}