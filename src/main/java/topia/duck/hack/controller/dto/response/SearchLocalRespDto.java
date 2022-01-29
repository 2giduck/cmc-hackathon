package topia.duck.hack.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SearchLocalRespDto {
    private List<Item> items;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class Item{
        private String title;

        private String category;

        private String description;

        private String address;

        private String roadAddress;
    }
}
