package topia.duck.hack.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import topia.duck.hack.controller.dto.response.SearchLocalRespDto;


@Service
public class OpenApiService {
    private final WebClient webClient = WebClient.builder().build();

    private final String NAVER_HOST = "openapi.naver.com";

    private final String MAP_SEARCH_END_POINT = "/v1/search/local.json";
    private final String QUERY_QUERY="query";
    private final String DISPLAY_QUERY = "display";

    private final String X_NAVER_CLIENT_ID_HEADER="X-Naver-Client-Id";
    private final String X_NAVER_CLIENT_SECRET_HEADER="X-Naver-Client-Secret";

    @Value("${openapi.naver.client.id}")
    private String clientId;
    @Value("${openapi.naver.client.secret}")
    private String clientSecret;

    public SearchLocalRespDto getMapList(String search) throws Exception{
        return webClient.get()
                .uri("https://"+NAVER_HOST+MAP_SEARCH_END_POINT+"?"+QUERY_QUERY+"="+search+"&"+DISPLAY_QUERY+"=5")
                .header(X_NAVER_CLIENT_ID_HEADER, clientId)
                .header(X_NAVER_CLIENT_SECRET_HEADER, clientSecret)
                .exchangeToMono(response->{
                    return response.bodyToMono(SearchLocalRespDto.class);
                })
                .block();
    }
}
