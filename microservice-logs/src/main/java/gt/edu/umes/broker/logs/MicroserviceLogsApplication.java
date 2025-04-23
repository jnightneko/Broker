package gt.edu.umes.broker.logs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MicroserviceLogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLogsApplication.class, args);
	}

}
