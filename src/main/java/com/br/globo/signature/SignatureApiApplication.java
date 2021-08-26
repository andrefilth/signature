package com.br.globo.signature;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@EnableRabbit
@SpringBootApplication
public class SignatureApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignatureApiApplication.class, args);
	}

}
