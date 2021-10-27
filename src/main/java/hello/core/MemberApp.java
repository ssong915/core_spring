package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) { // psvm + enter
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService()
// -> 기존

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //-> AppConfig 에 있는 환경설정 정보를 가지고, 스프링컨테이너에 넣어서 관리해줌
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        //-> appConfig의 이름: "memberService", 타입: MemberService.class 을 찾을거야

        Member member = new Member(1L, "memberA", Grade.VIP); // ctrl + alt + v
        memberService.join(member); // 가입!

        Member findMember = memberService.findMember(1L); // 조회!

        // 가입한 애랑 == 조회된 애랑 인지 확인
        System.out.println("new member = " + member.getName()); // soutv + enter
        System.out.println("find member = " + findMember.getName());
    }
}
