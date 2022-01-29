package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import topia.duck.hack.controller.dto.request.MemberCreateReqDto;
import topia.duck.hack.controller.dto.response.MemberCreateResDto;
import topia.duck.hack.domain.Member;
import topia.duck.hack.repository.MemberRepository;
import topia.duck.hack.service.MemberService;

@Controller
@RequestMapping("/api/auth")
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public ResponseEntity<MemberCreateResDto> login(@RequestBody MemberCreateReqDto memberCreateReqDto){
        Long memberNo = memberService.loginMember(memberCreateReqDto.getDeviceId());
        MemberCreateResDto memberCreateResDto = MemberCreateResDto.builder().memberNo(memberNo).build();

        return ResponseEntity.ok(memberCreateResDto);
    }
}
