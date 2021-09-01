package com.crudfarmacia.farmaciacrud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudfarmacia.farmaciacrud.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

}
