package me.choi.springinit;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringinitApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringinitApplication.class);
		springApplication.addListeners(new SampleListener());

		springApplication.run(args);
	}
}
