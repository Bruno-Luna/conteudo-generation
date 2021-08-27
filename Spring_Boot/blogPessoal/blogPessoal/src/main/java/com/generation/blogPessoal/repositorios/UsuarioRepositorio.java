package com.generation.blogPessoal.repositorios;

import java.util.List;
import java.util.Optional;

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
	 * @since 1.0
	 * @author Turma29
	 */
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
	/**
	 * Método utilizado para pesquisar coluna email
	 * 
	 * @param email do tipo String
	 * @return Optinal com Usuario
	 * @since 1.0
	 * @author Turma 29
	 */
	Optional<Usuario> finByEmail(String email);
}
