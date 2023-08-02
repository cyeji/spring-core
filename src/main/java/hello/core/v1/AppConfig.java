package hello.core.v1;

import hello.core.v1.discount.DiscountPolicy;
import hello.core.v1.discount.RateDiscountPolicy;
import hello.core.v1.member.MemberRepository;
import hello.core.v1.member.MemberService;
import hello.core.v1.member.MemberServiceImpl;
import hello.core.v1.member.MemoryMemberRepository;
import hello.core.v1.order.OrderService;
import hello.core.v1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
