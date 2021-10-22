package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberserviceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given : 이게 주어졌을 때
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when : 이때
        memberService.join(member);
        Member fineMember = memberService.findMember(1L);

        //then : 이게 수행된다
        Assertions.assertThat(member).isEqualTo(fineMember);
            // Assertions: 다양한 검증해주는 API 가 많음
    }
}
