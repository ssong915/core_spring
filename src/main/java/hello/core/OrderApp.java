package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) { //psvm + enter
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //-> AppConfig 에 있는 환경설정 정보를 가지고, 스프링컨테이너에 넣어서 관리해줌
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        //-> appConfig의 이름: "memberService", 타입: MemberService.class 을 찾을거야
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
        //-> appConfig의 이름: "orderService", 타입: OrderService.class 을 찾을거야


        // VIP 회원 하나 가입!
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문
        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
        //아까 말한 toString()이 실행될 것
        System.out.println("order = " + order.calculatePrice());
        // 아까 만든 itemPrice - discountPrice
    }

}
