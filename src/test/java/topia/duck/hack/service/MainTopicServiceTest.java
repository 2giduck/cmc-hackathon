package topia.duck.hack.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MainTopicServiceTest {
    @Autowired
    private MainTopicService mainTopicService;

    @Test
    public void 대주제_생성(){
        //given
        Long memberNo = Long.valueOf(1);
        String title = "제주도 여행";
        LocalDate startDate = LocalDate.of(2022, 1, 20);
        LocalDate endDate = LocalDate.of(2022, 1, 23);

        //when
        try{
            mainTopicService.createMainTopic(memberNo, title, startDate, endDate);
            assertThat(true);
        }catch(Exception e){
            assertThat(false);
        }

        //then
    }
}
