package topia.duck.hack.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import topia.duck.hack.controller.dto.response.MainTopicListRespDto;
import topia.duck.hack.domain.MainTopic;
import topia.duck.hack.domain.Member;
import topia.duck.hack.repository.MainTopicRepository;
import topia.duck.hack.repository.MemberRepository;
import topia.duck.hack.repository.SubTopicRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainTopicService {
    private final MainTopicRepository mainTopicRepository;
    private final SubTopicRepository subTopicRepository;
    private final MemberRepository memberRepository;

    public MainTopicService(MainTopicRepository mainTopicRepository, SubTopicRepository subTopicRepository, MemberRepository memberRepository) {
        this.mainTopicRepository = mainTopicRepository;
        this.subTopicRepository = subTopicRepository;
        this.memberRepository = memberRepository;
    }

    public MainTopicListRespDto getMainTopics(Long memberNo){
        List<MainTopic> mainTopics = mainTopicRepository.getMainTopics(memberNo);

        List<MainTopicListRespDto.MainTopics> mainTopicDtos
                = mainTopics.stream().map(m->{
                    Long mainNo = m.getMainNo();

                    List<LocalDateTime> localDateTimes = subTopicRepository.getPlanDtsByMainNo(mainNo);
                    List<LocalDate> dateList = localDateTimes.stream().map(l->l.toLocalDate()).distinct().sorted().collect(Collectors.toList());
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

    public void createMainTopic(Long memberNo, String title, LocalDate startDate, LocalDate endDate) throws Exception{
        Member member = new Member();
        member.setMemberNo(memberNo);

        MainTopic mainTopic = new MainTopic();
        mainTopic.setStartDate(startDate);
        mainTopic.setEndDate(endDate);
        mainTopic.setTitle(title);
        mainTopic.setMember(member);

        mainTopicRepository.createMainTopic(mainTopic);
    }
}
