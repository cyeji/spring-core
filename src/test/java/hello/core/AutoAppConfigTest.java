package hello.core;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoAppConfigTest {

    @Test
    @DisplayName("basicScan")
    void test_case_1() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertInstanceOf(MemberService.class, memberService);
    }
}