package com.generation.blogPessoal_II.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	public UsuarioModel usuario;
	public UsuarioModel usuarioNulo = new UsuarioModel();
	
	@Autowired
	private ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
	
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start () {
		
		usuario = new UsuarioModel(0L, "José Operário", "joao@email.com", "13240993");
		
	}
	
	@Test
	void testValidaAtributos() {
		
		Set<ConstraintViolation<UsuarioModel>> violacao = validator.validate(usuario);
	
		System.out.println(violacao.toString());
		
		assertTrue(violacao.isEmpty());
	}
	
	@Test
	void testNaoValidaAtributos() {
		
		Set<ConstraintViolation<UsuarioModel>> violacao = validator.validate(usuarioNulo);
	
		System.out.println(violacao.toString());
		
		assertFalse(violacao.isEmpty());
	}
}
