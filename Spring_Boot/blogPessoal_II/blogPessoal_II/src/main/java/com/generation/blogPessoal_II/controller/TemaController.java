package com.generation.blogPessoal_II.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal_II.model.PostagemModel;
import com.generation.blogPessoal_II.model.TemaModel;
import com.generation.blogPessoal_II.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<TemaModel>> getByTitulo(@PathVariable String tema){
		return ResponseEntity.ok(repository.findByTemaContainingIgnoreCase(tema));
	}
	
	@PostMapping
	public ResponseEntity<TemaModel> post(@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
}
