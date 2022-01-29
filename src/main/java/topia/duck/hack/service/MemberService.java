package topia.duck.hack.service;

import org.springframework.stereotype.Service;
import topia.duck.hack.domain.Member;
import topia.duck.hack.repository.MemberRepository;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long loginMember(String deviceId){
        Member member = new Member();
        member.setDeviceId(deviceId);

        Optional<Member> existMember = memberRepository.getMemberNo(deviceId);

        if(existMember.isPresent()) // 이미 존재하는 device_id라면
            return existMember.get().getMemberNo();

        Long memberNo = memberRepository.save(member);

        return memberNo;
    }
}
