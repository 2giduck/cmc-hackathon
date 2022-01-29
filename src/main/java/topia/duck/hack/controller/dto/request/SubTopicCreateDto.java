package topia.duck.hack.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubTopicCreateDto {
    @JsonProperty("main_no")
    private Long mainNo;

    @JsonProperty("title")
    private String title;

    @JsonProperty("plan_dt")
    private LocalDateTime planDt;

    @JsonProperty("description")
    private String description;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("address")
    private String address;
}
