package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import topia.duck.hack.controller.dto.MemberCreateReqDto;
import topia.duck.hack.controller.dto.MemberCreateResDto;
import topia.duck.hack.domain.Member;
import topia.duck.hack.repository.MemberRepository;

@Controller
@RequestMapping("/api/auth")
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<MemberCreateResDto> login(@RequestBody MemberCreateReqDto memberCreateReqDto){
        Member member = new Member();
        member.setDeviceId(memberCreateReqDto.getDeviceId());

        Long memberNo = memberRepository.save(member);
        MemberCreateResDto memberCreateResDto = MemberCreateResDto.builder().memberNo(memberNo).build();

        return ResponseEntity.ok(memberCreateResDto);
    }
}
