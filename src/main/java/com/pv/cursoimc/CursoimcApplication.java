package com.pv.cursoimc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pv.cursoimc.domain.Categoria;
import com.pv.cursoimc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoimcApplication implements CommandLineRunner{
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoimcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}

}
