package hello.core.member;

public interface MemberRepository {

    void save(Member member); // 가입

    Member findById(Long memberId); // ID로 회원찾기

}
