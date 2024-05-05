package com.aluracursos.desafiobuscarlibros;

import com.aluracursos.desafiobuscarlibros.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.event.PaintEvent;

@SpringBootApplication
public class DesafioBuscarLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBuscarLibrosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
