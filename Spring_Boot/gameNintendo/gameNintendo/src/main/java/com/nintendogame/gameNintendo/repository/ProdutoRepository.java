package com.nintendogame.gameNintendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nintendogame.gameNintendo.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
}
