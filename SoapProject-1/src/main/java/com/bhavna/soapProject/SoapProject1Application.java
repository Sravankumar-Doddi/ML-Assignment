package com.bhavna.soapProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.bhavna")
@SpringBootApplication
public class SoapProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SoapProject1Application.class, args);
	}

}
