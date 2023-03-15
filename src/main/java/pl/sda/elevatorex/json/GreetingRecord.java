package pl.sda.elevatorex.json;

import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public record GreetingRecord(String message) {
}
