package topia.duck.hack.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import topia.duck.hack.domain.Member;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 로그인(){
        //given
        String deviceId = "lajepqtjpowejtpqoejwptjqweithpqw";
        Member member = new Member();
        member.setDeviceId(deviceId);

        //when
        Long memberNo = memberRepository.save(member);

        //then
        System.out.println("memberNo = " + memberNo);
    }
}
