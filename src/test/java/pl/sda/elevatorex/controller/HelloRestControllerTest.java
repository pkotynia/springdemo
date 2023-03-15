package pl.sda.elevatorex.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerTest {

    @Test
    void helloTest(@Autowired WebTestClient webTestClient) {
        webTestClient
                .get().uri("/rest")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("""
                        {"message":"Hello, World!"}""");

    }

}