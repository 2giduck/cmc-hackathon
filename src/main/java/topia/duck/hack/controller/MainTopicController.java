package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import topia.duck.hack.controller.dto.request.MemberCreateReqDto;
import topia.duck.hack.controller.dto.response.MemberCreateResDto;
import topia.duck.hack.domain.Member;
import topia.duck.hack.repository.MainTopicRepository;

@Controller
@RequestMapping("/api/travel/main-topics")
public class MainTopicController {
    private final MainTopicRepository mainTopicRepository;

    public MainTopicController(MainTopicRepository mainTopicRepository) {
        this.mainTopicRepository = mainTopicRepository;
    }
}
