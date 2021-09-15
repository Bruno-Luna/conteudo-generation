package com.generation.blogPessoal_II.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogPessoal_II.model.UsuarioModel;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
	UsuarioModel usuario = new UsuarioModel(0L, "José Operário", "jose@email.com", "13240993");

	if(!usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
		usuarioRepository.save(usuario);
	
	usuario = new UsuarioModel(0L, "João Paulino", "joao@email.com", "13240993");

	if(!usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
		usuarioRepository.save(usuario);
	
	usuario = new UsuarioModel(0L, "Miguel Bento", "miguel@email.com", "13240993");

	if(!usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
		usuarioRepository.save(usuario);
	
	usuario = new UsuarioModel(0L, "Eustaquio Roberto", "eustaquio@email.com", "13240993");

	if(!usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
		usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("💾 Retorna Nome")
	public void findByRetornaNome() {
		
		UsuarioModel usuario = usuarioRepository.findByNome("João Paulino");
		assertTrue(usuario.getNome().equals("João Paulino"));
	}
	
	@Test
	@DisplayName("💾 Retorna 3 usuários")
		
		public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {
			List<UsuarioModel> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Bento");
			assertEquals(3, listaDeUsuarios.size());
		}
	
	@AfterAll
	public void end() {
		
		System.out.println("Teste finalizado");
	}
	
}

