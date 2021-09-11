package com.nintendogame.gameNintendo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nintendogame.gameNintendo.model.UsuarioModel;



@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
	
Optional<UsuarioModel> findByEmail(String email);
}
