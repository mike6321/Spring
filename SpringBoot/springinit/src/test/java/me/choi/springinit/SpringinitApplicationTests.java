package me.choi.springinit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "choi.name = junwoo2")
class SpringinitApplicationTests {

	@Autowired
	Environment environment;

	@Test
	@DisplayName("test")
	void contextLoads() {
		assertEquals(environment.getProperty("choi.name"),"junwoo2");
	}

}
