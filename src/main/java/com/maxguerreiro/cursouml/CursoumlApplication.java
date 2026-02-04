package com.maxguerreiro.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maxguerreiro.cursouml.domain.Categoria;
import com.maxguerreiro.cursouml.domain.Produto;
import com.maxguerreiro.cursouml.repositories.CategoriaRepository;
import com.maxguerreiro.cursouml.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
		
		
	}

	//implementado operação de instanciação de obj
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Games");
		Categoria cat2 = new Categoria(null, "Console");
		
		Produto p1 = new Produto(null, "Computador", 6000.00);
		Produto p2 = new Produto(null, "X-Box", 3000.00);
		Produto p3 = new Produto(null, "Mouse", 120.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// Persistindo os objs no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
