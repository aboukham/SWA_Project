package com.example.BooksQueryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BooksQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksQueryServiceApplication.class, args);
	}

}
