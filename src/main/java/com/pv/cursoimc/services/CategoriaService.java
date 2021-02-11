package com.pv.cursoimc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.cursoimc.domain.Categoria;
import com.pv.cursoimc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	public CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		} 
	
}
