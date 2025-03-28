package com.ejercicio.WebProyect;

import org.springframework.boot.SpringApplication;

public class TestWebProyectApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebProyectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
