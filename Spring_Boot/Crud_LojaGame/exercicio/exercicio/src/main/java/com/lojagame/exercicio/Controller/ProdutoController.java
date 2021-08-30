package com.lojagame.exercicio.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojagame.exercicio.Model.Produto;
import com.lojagame.exercicio.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIDProduto(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/produto/{nome}")
	public ResponseEntity<List<Produto>> findByDescricaoTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Produto> postProduto (@Valid @RequestBody Produto salvar){
		return ResponseEntity.ok(repository.save(salvar));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto salvar){
		return ResponseEntity.ok(repository.save(salvar));

	}
	
	@DeleteMapping("/deletar/{produto}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}
