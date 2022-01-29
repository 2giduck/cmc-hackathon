package topia.duck.hack.service;

import org.springframework.stereotype.Service;
import topia.duck.hack.controller.dto.response.MainTopicListRespDto;
import topia.duck.hack.domain.MainTopic;
import topia.duck.hack.repository.MainTopicRepository;
import topia.duck.hack.repository.SubTopicRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainTopicService {
    private final MainTopicRepository mainTopicRepository;
    private final SubTopicRepository subTopicRepository;

    public MainTopicService(MainTopicRepository mainTopicRepository, SubTopicRepository subTopicRepository) {
        this.mainTopicRepository = mainTopicRepository;
        this.subTopicRepository = subTopicRepository;
    }

    public MainTopicListRespDto getMainTopics(Long memberNo){
        List<MainTopic> mainTopics = mainTopicRepository.getMainTopics(memberNo);

        List<MainTopicListRespDto.MainTopics> mainTopicDtos
                = mainTopics.stream().map(m->{
                    Long mainNo = m.getMainNo();

                    List<LocalDateTime> localDateTimes = subTopicRepository.getPlanDtsByMainNo(mainNo);
                    List<LocalDate> dateList = localDateTimes.stream().map(l->l.toLocalDate()).distinct().collect(Collectors.toList());

                    return MainTopicListRespDto.MainTopics.builder()
                            .mainNo(mainNo)
                            .startDate(m.getStartDate())
                            .endDate(m.getEndDate())
                            .title(m.getTitle())
                            .dateList(dateList)
                            .build();
                    }).collect(Collectors.toList());

        // DTO
        MainTopicListRespDto mainTopicListRespDto = MainTopicListRespDto.builder().mainTopics(mainTopicDtos).build();

        return mainTopicListRespDto;
    }
}
