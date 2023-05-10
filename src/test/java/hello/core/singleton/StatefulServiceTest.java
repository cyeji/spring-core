package hello.core.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    @DisplayName("statefulServiceSingleton")
    void test_case_1() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB : 사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA 사용자 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertEquals(20000, statefulService1.getPrice());
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}