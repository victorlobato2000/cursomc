package com.pv.cursoimc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pv.cursoimc.domain.Cliente;
import com.pv.cursoimc.repositories.ClienteRepository;
import com.pv.cursoimc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	public ClienteRepository repo;
	public Cliente buscar(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+ id +", TIPO: "+ Cliente.class.getName()));
		} 
	
}
