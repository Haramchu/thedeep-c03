package apap.tutorial.manpromanpro.restservice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.cdimascio.dotenv.Dotenv;

@Service
public class RomanRestService {

    
    private String loadRomanApiUrl() {
        try {
            Dotenv dotenv = Dotenv.configure().load();
            return dotenv.get("ROMAN_API_URL");
        } catch (Exception e) {
            return System.getenv("ROMAN_API_URL");
        }
    }
    
    private final String romanApiUrl = loadRomanApiUrl();
    private final WebClient webClient = WebClient.builder()
    .baseUrl(romanApiUrl)
    .build();

    public Map<String, String> convertRomanToInteger(String roman) {
        try {
            return webClient.get()
                    .uri("/convert-roman/" + roman)
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::is4xxClientError,
                            clientResponse -> {
                                return clientResponse.bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                                })
                                .map(body -> new RuntimeException(body.get("error").toString()));
                            }
                    )
                    .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                    })
                    .block();
        } catch (Exception e) {
            HashMap<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return response;
        }
    }
    
    public Map<String, String> convertIntegerToRoman(String integer) {
        try {
            return webClient.get()
                    .uri("/convert-integer/" + integer)
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::is4xxClientError,
                            clientResponse -> {
                                return clientResponse.bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                                })
                                .map(body -> new RuntimeException(body.get("error").toString()));
                            }
                    )
                    .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                    })
                    .block();
        } catch (Exception e) {
            HashMap<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return response;
        }
    }
}
