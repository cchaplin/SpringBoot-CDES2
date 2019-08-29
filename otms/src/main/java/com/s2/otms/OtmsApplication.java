package com.s2.otms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsApplication.class, args);
	}

}
