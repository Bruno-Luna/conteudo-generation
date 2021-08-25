package com.generation.blogPessoal.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.modelos.Usuario;
import com.generation.blogPessoal.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControlador {

	private @Autowired UsuarioRepositorio repositorio;
	
	@GetMapping("/todosusuarios")
	public List<Usuario> pegarUsuarios(){
		return repositorio.findAll();
	}
}
