package com.generation.blogPessoal_II.controller;

import java.util.List;
import java.util.Optional;

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

import com.generation.blogPessoal_II.model.PostagemModel;
import com.generation.blogPessoal_II.model.UsuarioModel;
import com.generation.blogPessoal_II.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/buscarPorId{id}")
	public ResponseEntity<PostagemModel> getById(@PathVariable(value = "id") Long id){
		Optional<PostagemModel> objetoUsuario = repository.findById(id);
		if(objetoUsuario.isPresent()){
			return ResponseEntity.status(200).body(objetoUsuario.get());
		}else {
			return ResponseEntity.status(204).build();
		}
		
	}
	
	@GetMapping("/buscarPorTitulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> getByPostagem(@PathVariable(value = "titulo") String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<PostagemModel> post(@RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping("/atualizar/{comparar}")
	public ResponseEntity<PostagemModel> atualizar(@RequestBody PostagemModel postagemAtualizar, @PathVariable(value = "comparar") Long comparar){
		
		if(repository.existsById(comparar) != false && comparar == postagemAtualizar.getIdPostagem()) {
			
			return ResponseEntity.status(201).body(repository.save(postagemAtualizar));
		} else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@DeleteMapping("/deletar/{id_postagem}")
	public void deletarPostagem (@PathVariable(value = "id_postagem") Long idPostagem) {
		repository.deleteById(idPostagem);
	}
}