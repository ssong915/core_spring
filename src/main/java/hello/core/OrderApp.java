package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) { //psvm + enter

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // VIP 회원 하나 가입!
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문
        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
        //아까 말한 toString()이 실행될 것
        System.out.println("order = " + order.calculatePrice());
        // 아까 만든 itemPrice - discoutPrice
    }

}
