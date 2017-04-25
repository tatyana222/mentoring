package com.epam.mentoring.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// to run app using Gradle wrapper type the command:
// gradlew build && java -jar build/libs/webapp-project-1.0.jar
// then go to http://localhost:8080
@SpringBootApplication
public class WebappProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappProjectApplication.class, args);
	}
}
