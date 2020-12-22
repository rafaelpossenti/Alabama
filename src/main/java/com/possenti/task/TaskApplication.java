package com.possenti.task;

import com.possenti.task.entity.Task;
import com.possenti.task.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Profile("demo")
	@Bean
	CommandLineRunner initDatabase(TaskRepository repository) {
		return args -> {
			repository.save(new Task(1l, "A Guide to the Bodhisattva Way of Life", "Santideva", LocalDate.now()));
			repository.save(new Task(2l, "The Life-Changing Magic of Tidying Up", "Marie Kondo", LocalDate.now()));
			repository.save(new Task(3l, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", LocalDate.now()));

		};
	}
}
