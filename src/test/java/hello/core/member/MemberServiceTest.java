package hello.core.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService =  new MemberServiceImpl();

    @Test
    void join(){
        //given
        long id = 1L;
        Member member = new Member(id, "memberA", Grade.BASIC);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(id);

        //then
        assertEquals(member,findMember);
    }

}