package com.bhavna.NaukriServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NaukriServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaukriServerApplication.class, args);
	}

}
