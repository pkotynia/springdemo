package pl.sda.elevatorex.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstroServiceRestTemplate {

    private final RestTemplateBuilder builder;

    public AstroServiceRestTemplate(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    public AstroResult getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return builder.build().getForObject(url, AstroResult.class);
    }

    public static record AstroResult(String message, Integer number, List<Astronaut> people) {
    }

    public static record Astronaut(String craft, String name) {
    }
}

