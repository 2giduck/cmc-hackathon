package topia.duck.hack.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SubTopicListRespDto {
    @JsonProperty("complete_rate")
    private int completeRate;

    @JsonProperty("sub_topics")
    private List<SubTopicListRespDto.SubTopics> subTopics;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SubTopics{
        @JsonProperty("sub_no")
        private Long subNo;

        @JsonProperty("title")
        private String title;

        @JsonProperty("plan_dt")
        private LocalDateTime planDt;

        @JsonProperty("description")
        private String description;

        @JsonProperty("is_complete")
        private boolean isComplete;

        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;
    }
}
