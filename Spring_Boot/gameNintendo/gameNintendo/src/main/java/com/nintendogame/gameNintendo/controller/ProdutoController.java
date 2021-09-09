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

import com.nintendogame.gameNintendo.model.ProdutoModel;
import com.nintendogame.gameNintendo.repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired ProdutoRepository repository;
	
	@GetMapping("/pegar_todos")
	public ResponseEntity<List<ProdutoModel>> pegarTodos(){
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/pegar_por_id/{idProd}")
	public ResponseEntity<ProdutoModel> pegarPorId(@PathVariable (value = "idProd") Long idProduto){
		Optional<ProdutoModel> objetoProduto = repository.findById(idProduto);
			
			if(objetoProduto.isPresent()) {
				return ResponseEntity.status(200).body(objetoProduto.get());
			} else {
				return ResponseEntity.status(204).build();
			}
	}
	
	@GetMapping("/buscar_por_nome/{nomeProd}")
	public ResponseEntity<List<ProdutoModel>> buscarPorNome(@PathVariable(value = "nomeProd") String nome){
		
		List<ProdutoModel> objetoProduto = repository.findAllByNomeContainingIgnoreCase(nome);
			if(objetoProduto.isEmpty()) {
				return ResponseEntity.status(204).build();
			} else {
				return ResponseEntity.status(200).body(objetoProduto);
			}
	}

	@PostMapping("/postar_produto")
	public ResponseEntity<ProdutoModel> postarProduto(@Valid @RequestBody ProdutoModel salvarProduto){
		return ResponseEntity.status(201).body(repository.save(salvarProduto));
	}

	@PutMapping("/atualizar_produto")
	public ResponseEntity<ProdutoModel> atualizarProduto (@Valid @RequestBody ProdutoModel atualizarProduto){
		return ResponseEntity.status(201).body(repository.save(atualizarProduto));
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarProduto(@PathVariable (value = "id") Long IdProduto) {
		repository.deleteById(IdProduto);
	}
}
