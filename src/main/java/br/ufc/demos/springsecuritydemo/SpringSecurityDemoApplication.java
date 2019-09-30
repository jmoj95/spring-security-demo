package br.ufc.demos.springsecuritydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufc.demos.springsecuritydemo.models.Role;
import br.ufc.demos.springsecuritydemo.models.User;
import br.ufc.demos.springsecuritydemo.services.UserService;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	@Bean
	public CommandLineRunner setupDefaultUser(UserService service) {
		return args -> {
			service.save(new User("user", "user", new Role("USER")));
			service.save(new User("admin", "admin", new Role("ADMIN")));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

}
