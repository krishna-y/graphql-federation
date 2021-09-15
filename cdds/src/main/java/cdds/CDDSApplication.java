package cdds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CDDSApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CDDSApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8083"));
		app.run(args);
	}

}
