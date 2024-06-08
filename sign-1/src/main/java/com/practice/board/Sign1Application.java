package com.practice.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.practice.api", "com.practice.board"})
public class Sign1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sign1Application.class, args);
	}

}
