package co.edu.uco.reservasrestaurante.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"package co.edu.uco.reservasrestaurante.controller"})
public class ReservasRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasRestauranteApplication.class, args);
	}

}
