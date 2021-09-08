package com.generation.blogPessoal_II.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/{idTema}")
	public ResponseEntity<TemaModel> getById(@PathVariable Long idTema){
		return repository.findById(idTema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<TemaModel>> getByTema(@PathVariable String tema){
		return ResponseEntity.ok(repository.findByTemaContainingIgnoreCase(tema));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<TemaModel> post(@RequestBody TemaModel temaSalvar){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(temaSalvar));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<TemaModel> atualizar(@Valid @RequestBody TemaModel TemaAtualizar){
		return ResponseEntity.status(201).body(repository.save(TemaAtualizar));
	}
	
	@DeleteMapping("/deletar/{id_Tema}")
	public void deletarTema (@PathVariable(value = "id_tema") Long idTema) {
		repository.deleteById(idTema);
	}
	
}
