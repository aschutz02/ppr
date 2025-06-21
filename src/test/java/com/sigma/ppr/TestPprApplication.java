package com.sigma.ppr;

import org.springframework.boot.SpringApplication;

public class TestPprApplication {

	public static void main(String[] args) {
		SpringApplication.from(PprApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
