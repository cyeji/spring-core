package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void test_case_1() {
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }


    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void test_case_2() {
        MemberService memberService = applicationContext.getBean(MemberService.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void test_case_3() {
        MemberServiceImpl memberService = applicationContext.getBean(MemberServiceImpl.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void test_case_4() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("XXXX", MemberService.class));
    }
}
