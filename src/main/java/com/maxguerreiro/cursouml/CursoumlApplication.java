package com.maxguerreiro.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maxguerreiro.cursouml.domain.Categoria;
import com.maxguerreiro.cursouml.domain.Cidade;
import com.maxguerreiro.cursouml.domain.Estado;
import com.maxguerreiro.cursouml.domain.Produto;
import com.maxguerreiro.cursouml.repositories.CategoriaRepository;
import com.maxguerreiro.cursouml.repositories.CidadeRepository;
import com.maxguerreiro.cursouml.repositories.EstadoRepository;
import com.maxguerreiro.cursouml.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
