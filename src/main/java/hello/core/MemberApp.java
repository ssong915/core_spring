package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) { // psvm + enter
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP); // ctrl + alt + v
        memberService.join(member); // 가입!

        Member findMember = memberService.findMember(1L); // 조회!

        // 가입한 애랑 == 조회된 애랑 인지 확인
        System.out.println("new member = " + member.getName()); // soutv + enter
        System.out.println("find member = " + findMember.getName());
    }
}
