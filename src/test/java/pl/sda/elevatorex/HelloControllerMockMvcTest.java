package pl.sda.elevatorex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.sda.elevatorex.controller.HelloController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMvcTest {

//    @Autowired
    private MockMvc mockMvc;


    @Autowired
    public HelloControllerMockMvcTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void testHelloWithoutName(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(content().string(containsString("Hello, World")));
    }
// budżet
// QA z Indii czy oni
    // nie równe rozdzielenie pracy - dużo na głowie, zawaleni są
    // Dominik woli sam zrobić
    // Spotkania mało standup 7 minut,
    // opowiadał co było na meetingu na standupie
    // spotkania porażki
    // Backlog - bierzcie z tego wszys

    // zdrowy rozsądek

    // releasy i an calle są chaotyczne

    // BAU po co jest jak się robi swoje zadania

    //Feedback, reguralny

    //Stroty czasu, zmiany priorytetów, koncepcji
    //Polska jest pomijana, to jest mniejszy problem ale outcome decyzji nie jest komunikowany

}
