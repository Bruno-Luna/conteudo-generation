package com.generation.blogPessoal.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.modelos.Postagem;
import com.generation.blogPessoal.repositorios.PostagemRepositorio;

@RestController
@RequestMapping("/api/v1/postagem")
public class PostagemControlador {

	private @Autowired PostagemRepositorio repositorio;
	
	@GetMapping("/todaspostagem")
	public List<Postagem> pegarPostagem(){
		return repositorio.findAll();
	}
}
