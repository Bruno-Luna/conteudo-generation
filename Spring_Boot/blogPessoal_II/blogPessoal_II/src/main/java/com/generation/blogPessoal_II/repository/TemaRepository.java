package com.generation.blogPessoal_II.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal_II.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	List<TemaModel> findByTemaContainingIgnoreCase(String tema);
}
