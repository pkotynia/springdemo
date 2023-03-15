package pl.sda.elevatorex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class ElevatorexApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		System.out.println(context.getBeanDefinitionCount());
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

	}

}
