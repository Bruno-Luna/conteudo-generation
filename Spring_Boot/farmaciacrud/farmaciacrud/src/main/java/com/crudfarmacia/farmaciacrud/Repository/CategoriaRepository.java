package com.crudfarmacia.farmaciacrud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudfarmacia.farmaciacrud.Model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);
}
