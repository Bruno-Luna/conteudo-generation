package com.generation.blogPessoal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogPessoal.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	/**
	 * Metodo utilizado para pesquisar coluna nome ContainingIgnoreCase
	 * 
	 * @param nome do tipo String
	 * @return List de Usuario
	 * 
	 * @author Turma29
	 */
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
