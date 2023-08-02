package hello.core.v1.xml;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import hello.core.v1.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class XmlAppContext {


    @Test
    @DisplayName("xmlAppContext")
    void test_case_1() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertInstanceOf(MemberService.class, memberService);
    }

}
