package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import topia.duck.hack.controller.dto.response.MainTopicListRespDto;
import topia.duck.hack.service.MainTopicService;

@Controller
@RequestMapping("/api/travel/main-topics")
public class MainTopicController {
    private final MainTopicService mainTopicService;

    public MainTopicController(MainTopicService mainTopicService) {
        this.mainTopicService = mainTopicService;
    }

    @GetMapping
    public ResponseEntity getMainTopics(@RequestHeader(value="X-MEMBER-NO")Long memberNo){
        MainTopicListRespDto mainTopicListRespDto = mainTopicService.getMainTopics(memberNo);

        return ResponseEntity.ok(mainTopicListRespDto);
    }
}
