package topia.duck.hack.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SubTopicServiceTest {
    @Autowired
    private SubTopicService subTopicService;

    @Test
    public void 서브_계획_생성(){
        //given
        Long mainNo = Long.valueOf(1);
        String title = "아 집에가고싶다";
        LocalDateTime dateTime = LocalDateTime.now();
        double latitude = 1;
        double longitude = 1;

        //when
        try {
            subTopicService.createSubTopic(mainNo, title, dateTime, null, latitude, longitude, null );
            assertThat(true);
        } catch (Exception e) {
            assertThat(false);
        }

        //then

    }
}
