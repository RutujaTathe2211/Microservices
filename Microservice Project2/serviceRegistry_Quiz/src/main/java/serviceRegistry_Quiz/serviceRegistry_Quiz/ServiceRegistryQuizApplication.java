package serviceRegistry_Quiz.serviceRegistry_Quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryQuizApplication.class, args);
	}

}
