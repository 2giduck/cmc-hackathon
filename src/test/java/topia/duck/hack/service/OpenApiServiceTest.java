package topia.duck.hack.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import topia.duck.hack.controller.dto.response.SearchLocalRespDto;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OpenApiServiceTest {
    @Autowired
    private OpenApiService openApiService;

    @Test
    public void 주소_리스트_가져오기(){
        //given
        String query = "김부삼";

        //when
        try {
            SearchLocalRespDto searchLocalRespDto = openApiService.getMapList(query);
            assertThat(true);
        } catch (Exception e) {
            assertThat(false);
        }

        //then
    }
}
