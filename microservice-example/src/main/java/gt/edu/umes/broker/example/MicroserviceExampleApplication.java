package gt.edu.umes.broker.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExampleApplication.class, args);
	}

}
