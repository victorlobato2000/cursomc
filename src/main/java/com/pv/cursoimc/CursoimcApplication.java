package com.pv.cursoimc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pv.cursoimc.domain.Categoria;
import com.pv.cursoimc.domain.Cidade;
import com.pv.cursoimc.domain.Estado;
import com.pv.cursoimc.domain.Produto;
import com.pv.cursoimc.repositories.CategoriaRepository;
import com.pv.cursoimc.repositories.CidadeRepository;
import com.pv.cursoimc.repositories.EstadoRepository;
import com.pv.cursoimc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoimcApplication implements CommandLineRunner{
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	@Autowired
	public ProdutoRepository produtoRepository;
	@Autowired
	public EstadoRepository estadoRepository;
	@Autowired
	public CidadeRepository cidadeRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursoimcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto pro1 = new Produto(null,"Computador", 2000.00);
		Produto pro2 = new Produto(null,"Impressora", 800.00);
		Produto pro3 = new Produto(null,"Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1,pro2,pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(pro1,pro2,pro3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}

