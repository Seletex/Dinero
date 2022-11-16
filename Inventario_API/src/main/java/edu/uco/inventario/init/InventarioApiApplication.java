package edu.uco.inventario.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.uco.inventario"})
public class InventarioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApiApplication.class, args);
	}

}
