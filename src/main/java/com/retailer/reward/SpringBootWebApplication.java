package com.retailer.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootWebApplication {

	public static void main(String[] args) {
		System.out.println("its on !!! ");
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
