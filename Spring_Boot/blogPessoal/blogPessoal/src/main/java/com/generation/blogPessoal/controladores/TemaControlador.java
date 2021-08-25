package com.generation.blogPessoal.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.modelos.Tema;
import com.generation.blogPessoal.repositorios.TemaRepositorio;

@RestController
@RequestMapping("/api/v1/tema")
public class TemaControlador {
	
	private @Autowired TemaRepositorio repositorio;
	
	@GetMapping("/todostemas")
	public List<Tema> pegarTema() {
		return repositorio.findAll();
	}
}
