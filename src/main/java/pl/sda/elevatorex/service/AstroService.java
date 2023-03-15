package pl.sda.elevatorex.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AstroService {

    private final WebClient client;

    public AstroService(WebClient client) {
        this.client = client;
    }

    public void getPeopleInSpace(){
        String retrieve = client.get()
                .uri("http://api.open-notify.org/astros.json")
                .retrieve().bodyToMono(String.class).block();

        System.out.println(retrieve);
    }
}
