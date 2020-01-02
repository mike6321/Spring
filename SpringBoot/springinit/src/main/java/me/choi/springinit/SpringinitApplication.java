package me.choi.springinit;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringinitApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringinitApplication.class, args);
		SpringApplication springApplication = new SpringApplication(SpringinitApplication.class);
		springApplication.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.println("===========================");
				out.println("Hello");
				out.println("===========================");
			}
		});
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}
}
