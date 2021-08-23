package com.helloWorld.Hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Habilidades e Mentalidades: Mentalidade de Crescimento, "
				+ "Atenção aos detalhes, "
				+ "Trabalho em equipe.";
	}
	
	@GetMapping("/hello1")
	public String hello1() {
		return "Objetivos de aprendizagem: "
				+ "Ampliar meus conhecimentos sobre verbos HTTP. "
				+ "Conhecer bem o Spring Boot "
				+ "Saber e diferenciar Framework de Bibliotecas, "
				+ "Pesquisar e conhecer mais sobre as arquitetura SEFOA.";
	}
	
}
