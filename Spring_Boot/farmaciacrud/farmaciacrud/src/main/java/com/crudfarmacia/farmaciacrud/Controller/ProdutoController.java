package com.crudfarmacia.farmaciacrud.Controller;

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

import com.crudfarmacia.farmaciacrud.Model.Produto;
import com.crudfarmacia.farmaciacrud.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIDCategoria(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{produto}")
	public ResponseEntity<List<Produto>> findByDescricaoCategoria(@PathVariable String produto){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(produto));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Produto> postCategoria(@Valid @RequestBody Produto salvar){
		return ResponseEntity.ok(repository.save(salvar));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Produto> putCategoria(@Valid @RequestBody Produto atualizar){
		return ResponseEntity.ok(repository.save(atualizar));
	}
	
	@DeleteMapping("/delete")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
