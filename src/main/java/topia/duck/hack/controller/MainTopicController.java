package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import topia.duck.hack.controller.dto.request.MainTopicCreateDto;
import topia.duck.hack.controller.dto.response.MainTopicListRespDto;
import topia.duck.hack.repository.MainTopicRepository;
import topia.duck.hack.service.MainTopicService;

@Controller
@RequestMapping("/api/travel/main-topics")
public class MainTopicController {
    private final MainTopicService mainTopicService;
    private final MainTopicRepository mainTopicRepository;

    public MainTopicController(MainTopicService mainTopicService, MainTopicRepository mainTopicRepository) {
        this.mainTopicService = mainTopicService;
        this.mainTopicRepository = mainTopicRepository;
    }

    @GetMapping
    public ResponseEntity getMainTopics(@RequestHeader(value="X-MEMBER-NO")Long memberNo){
        MainTopicListRespDto mainTopicListRespDto = mainTopicService.getMainTopics(memberNo);

        return ResponseEntity.ok(mainTopicListRespDto);
    }

    @PostMapping
    public ResponseEntity createMainTopic(@RequestHeader(value="X-MEMBER-NO")Long memberNo,
                                          @RequestBody MainTopicCreateDto mainTopicCreateDto){
        try{
            mainTopicService.createMainTopic(memberNo, mainTopicCreateDto.getTitle(), mainTopicCreateDto.getStartDate(),
                    mainTopicCreateDto.getEndDate());
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
