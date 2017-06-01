package com.epam.mentoring.webapp;

import com.epam.mentoring.webapp.domain.Role;
import com.epam.mentoring.webapp.domain.User;
import com.epam.mentoring.webapp.repository.UserRepository;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import static com.epam.mentoring.webapp.domain.Role.USER;

// to run app using Gradle wrapper type the command:
// gradlew build && java -jar build/libs/webapp-project-1.0.jar
// then go to http://localhost:8080
@SpringBootApplication
public class WebappProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappProjectApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {

		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

		Connector ajpConnector = new Connector("AJP/1.3");
		ajpConnector.setPort(8009);
		ajpConnector.setSecure(false);
		ajpConnector.setAllowTrace(false);
		ajpConnector.setScheme("http");
		tomcat.addAdditionalTomcatConnectors(ajpConnector);

		return tomcat;
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new User(1L, "user1", "user1_password", USER, "User1", "user1@user-email.com"));
			userRepository.save(new User(2L, "user2", "user2_password", USER, "User2", "user2@user-email.com"));
			userRepository.save(new User(3L, "user3", "user3_password", USER, "User3", "user3@user-email.com"));
			userRepository.save(new User(4L, "user4", "user4_password", USER, "User4", "user4@user-email.com"));
			userRepository.save(new User(5L, "user5", "user5_password", USER, "User5", "user5@user-email.com"));
		};
	}
}
