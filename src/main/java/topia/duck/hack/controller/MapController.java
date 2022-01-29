package topia.duck.hack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import topia.duck.hack.controller.dto.response.SearchLocalRespDto;
import topia.duck.hack.service.OpenApiService;

@Controller
@RequestMapping("/api/travel/map")
public class MapController {
    private final OpenApiService openApiService;

    public MapController(OpenApiService openApiService) {
        this.openApiService = openApiService;
    }

    @GetMapping
    public ResponseEntity getMapList(@RequestParam("search") String search){
        SearchLocalRespDto searchLocalRespDto = null;
        try {
            searchLocalRespDto = openApiService.getMapList(search);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok(searchLocalRespDto);
    }


}
