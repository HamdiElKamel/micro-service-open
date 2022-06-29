package com.clientsui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.clientsui")
@SpringBootApplication
public class ClientsuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsuiApplication.class, args);
	}
}
