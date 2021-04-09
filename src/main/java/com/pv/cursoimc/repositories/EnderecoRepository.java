package com.pv.cursoimc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pv.cursoimc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
