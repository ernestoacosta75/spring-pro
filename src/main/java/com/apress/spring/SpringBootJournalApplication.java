package com.apress.spring;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringBootJournalApplication {

	@Bean
	InitializingBean saveData(JournalRepository journalRepository) {
		return () -> {
			journalRepository.save(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot",
					new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2016")));
			journalRepository.save(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project",
					new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2016")));
			journalRepository.save(new Journal("Spring Boot Reading", "Read more about Spring Boot",
					new SimpleDateFormat("dd/MM/yyyy").parse("02/01/2016")));
			journalRepository.save(new Journal("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry",
					new SimpleDateFormat("dd/MM/yyyy").parse("03/01/2016")));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
}
