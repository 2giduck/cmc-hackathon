package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import topia.duck.hack.controller.dto.response.SubTopicListRespDto;
import topia.duck.hack.service.SubTopicService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/api/travel/sub-topics")
public class SubTopicController {
    private final SubTopicService subTopicService;

    public SubTopicController(SubTopicService subTopicService) {
        this.subTopicService = subTopicService;
    }

    @GetMapping
    public ResponseEntity<SubTopicListRespDto> getSubTopics(@RequestParam("main_no")Long mainNo, @RequestParam("date")String date){
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

        SubTopicListRespDto subTopicListRespDto = subTopicService.getSubTopics(mainNo, localDate);

        return ResponseEntity.ok(subTopicListRespDto);
    }
}
