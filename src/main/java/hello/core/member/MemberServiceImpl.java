package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    //memorymemberRepository 에 대한 정보 X -> 이넘을 appconfig 가 함

    public MemberServiceImpl(MemberRepository memberRepository) { //생성자를 통해서 할당해줌 만들도록 함
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
