package pl.sda.Persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.sda.Persons.config.PersonConfiguration;

@SpringBootApplication
@Import(PersonConfiguration.class)
public class PersonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonsApplication.class, args);
	}
}
