package me.choi.demospring51;

import me.choi.outpackage.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Demospring51Application {

	@Autowired
	MyService myService;


	public static void main(String[] args) {
		SpringApplication.run(Demospring51Application.class, args);
	}
}
