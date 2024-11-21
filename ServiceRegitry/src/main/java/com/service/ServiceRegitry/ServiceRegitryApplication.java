package com.service.ServiceRegitry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegitryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegitryApplication.class, args);
	}

}
