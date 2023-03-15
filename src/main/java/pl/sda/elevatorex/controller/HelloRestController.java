package pl.sda.elevatorex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.elevatorex.json.GreetingRecord;
import pl.sda.elevatorex.service.AstroServiceRestTemplate;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RestController
public class HelloRestController {

    private AstroServiceRestTemplate service;

    public HelloRestController(AstroServiceRestTemplate service) {
        this.service = service;
    }

    @GetMapping("/rest")
    public GreetingRecord greet(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println(service.getAstronauts()
                .people()
                .stream()
                .collect(groupingBy(AstroServiceRestTemplate.Astronaut::craft, Collectors.counting())));
        return new GreetingRecord("Hello, " + name + "!");
    }

}
