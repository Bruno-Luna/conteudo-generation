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

import com.lojagame.exercicio.Model.Categoria;
import com.lojagame.exercicio.Repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody  Categoria salvar){
		return ResponseEntity.ok(repository.save(salvar));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria salvar){
		return ResponseEntity.ok(repository.save(salvar));
	}
	
	@DeleteMapping("/deletar/{descricao}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}

}

