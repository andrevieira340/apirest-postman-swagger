package com.spring.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);
	Produto deleteById(long id);

}
