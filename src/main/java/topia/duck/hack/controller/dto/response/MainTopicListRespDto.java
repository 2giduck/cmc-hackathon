package topia.duck.hack.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MainTopicListRespDto {
    @JsonProperty("main_topics")
    private List<MainTopics> mainTopics;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MainTopics{
        @JsonProperty("main_no")
        private Long mainNo;

        @JsonProperty("title")
        private String title;

        @JsonProperty("start_date")
        private LocalDate startDate;

        @JsonProperty("end_date")
        private LocalDate endDate;

        @JsonProperty("date_list")
        private List<LocalDate> dateList;
    }
}
