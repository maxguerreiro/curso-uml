package com.maxguerreiro.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maxguerreiro.cursouml.domain.Categoria;
import com.maxguerreiro.cursouml.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
		
		
	}

	//implementado operação de instanciação de obj
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Consoles");
		Categoria cat2 = new Categoria(null, "Gamer");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
