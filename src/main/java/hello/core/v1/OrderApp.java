package hello.core.v1;

import hello.core.v1.member.Grade;
import hello.core.v1.member.Member;
import hello.core.v1.member.MemberService;
import hello.core.v1.order.Order;
import hello.core.v1.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {


    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberAIP", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "cheese", 10000);

        System.out.println("order = " + order);

    }
}
