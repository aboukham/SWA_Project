package com.example.BooksCommandService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class BooksCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksCommandServiceApplication.class, args);
	}

}
