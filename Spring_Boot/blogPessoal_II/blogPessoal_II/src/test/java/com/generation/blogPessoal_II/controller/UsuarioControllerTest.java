package com.generation.blogPessoal_II.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.blogPessoal_II.model.UsuarioModel;
import com.generation.blogPessoal_II.repository.UsuarioRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {
	
	@Autowired
	private TestRestTemplate testeRestTemplate;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private UsuarioModel usuario;
	private UsuarioModel usuarioUpdate;
	private UsuarioModel usuarioAdmin;

	@BeforeAll
	public void start() {
		
		usuarioAdmin = new UsuarioModel(0L, "Administrador", "admin@email.com", "1098993");
		
		if(!usuarioRepository.findByEmail(usuarioAdmin.getEmail()).isPresent()) {
			HttpEntity<UsuarioModel> request = new HttpEntity<UsuarioModel>(usuarioAdmin);
			testeRestTemplate.exchange("/usuario/salvar",HttpMethod.POST,request, UsuarioModel.class);
		}
		
		usuario = new UsuarioModel(0L, "Bernadino Siena", "b_siena@email.com", "berna993");
		
		usuarioUpdate = new UsuarioModel(2L, "Bernadino de Siena", "benardino@email.com", "siena8993");

	}
	
	@Test
	@DisplayName("✔ Cadastrar usuário")
	@Order(1)
	public void deveRealizarPostUsuario() {
		
		HttpEntity<UsuarioModel> request = new HttpEntity<UsuarioModel>(usuario);
		ResponseEntity<UsuarioModel> resposta = testeRestTemplate.exchange("/usuario/salvar",HttpMethod.POST,request, UsuarioModel.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("✨ Listar todos os usuários")
	@Order(2)
	public void deveRealizarGetAllUsuario() {
		
		ResponseEntity<String> resposta = testeRestTemplate.withBasicAuth("admin@email.com", "1098993").exchange("/usuario/todos",HttpMethod.GET,null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());

	}
	
	/*
	@Test
	@DisplayName("🙌 Alterar usuário")
	@Order(3)
	public void deveRealizarPutUsuario() {
		
		HttpEntity<UsuarioModel> request = new HttpEntity<UsuarioModel>(usuarioUpdate);
		ResponseEntity<UsuarioModel> resposta = testeRestTemplate.withBasicAuth("admin@email.com", "1098993").exchange("/usuario/atualizar",HttpMethod.PUT, request, UsuarioModel.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());

	}
	 */

}
