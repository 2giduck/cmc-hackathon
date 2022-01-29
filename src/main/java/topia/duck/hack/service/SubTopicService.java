package topia.duck.hack.service;

import org.springframework.stereotype.Service;
import topia.duck.hack.controller.dto.response.SubTopicListRespDto;
import topia.duck.hack.repository.SubTopicRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubTopicService {
    private final SubTopicRepository subTopicRepository;

    public SubTopicService(SubTopicRepository subTopicRepository) {
        this.subTopicRepository = subTopicRepository;
    }

    public SubTopicListRespDto getSubTopics(Long mainNo, LocalDate date){
        List<SubTopicListRespDto.SubTopics> subTopics =
                subTopicRepository.getSubTopics(mainNo, date).stream()
                        .map(s->{
                            SubTopicListRespDto.SubTopics subTopic = SubTopicListRespDto.SubTopics.builder()
                                    .subNo(s.getSubNo())
                                    .title(s.getTitle())
                                    .planDt(s.getPlanDt())
                                    .description(s.getDescription())
                                    .isComplete(s.isComplete())
                                    .latitude(s.getLatitude())
                                    .longitude(s.getLongitude())
                                    .build();

                            return subTopic;
                        }).collect(Collectors.toList());

        //DTO
        SubTopicListRespDto subTopicListRespDto = SubTopicListRespDto.builder().subTopics(subTopics).build();

        return subTopicListRespDto;
    }
}
