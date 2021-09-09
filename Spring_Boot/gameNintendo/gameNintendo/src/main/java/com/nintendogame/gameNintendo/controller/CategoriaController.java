package com.nintendogame.gameNintendo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nintendogame.gameNintendo.model.CategoriaModel;
import com.nintendogame.gameNintendo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired 
	private CategoriaRepository repository;
	
	@GetMapping("/pegar_todos")
	public ResponseEntity<List<CategoriaModel>> pegarTodos(){
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/pegar_por_id/{id}")
	public ResponseEntity<CategoriaModel> pegarPorId(@PathVariable(value = "id") Long idCategoria){
		Optional<CategoriaModel> objetoCategoria = repository.findById(idCategoria);
		if(objetoCategoria.isPresent()) {
			return ResponseEntity.status(200).body(objetoCategoria.get());
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/buscar_por_descricao/{desc}")
	public ResponseEntity<List<CategoriaModel>> buscarPorDescricao(@PathVariable (value = "desc") String descricao){
		List<CategoriaModel> objetoCategoria = repository.findAllByDescricaoContainingIgnoreCase(descricao);
		if(objetoCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(204).body(objetoCategoria);
		}
	}
	
	@PostMapping("/postar_categoria")
	public ResponseEntity<CategoriaModel> postarCategoria(@Valid @RequestBody CategoriaModel salvarCategoria){
		return ResponseEntity.status(201).body(repository.save(salvarCategoria));
	}
	
	@PutMapping("/atualizar_categoria")
	public ResponseEntity<CategoriaModel> atualizarCategoria(@Valid @RequestBody CategoriaModel atualizarCategoria){
		return ResponseEntity.status(201).body(repository.save(atualizarCategoria));
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarCategoria(@PathVariable (value = "id") Long idCategoria) {
		repository.deleteById(idCategoria);
	}
	
	
	
	
}
