package com.whisper.coopermedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class CooperMediaApplication {
	public static void main(String[] args) {
		SpringApplication.run(CooperMediaApplication.class, args);
	}
}
