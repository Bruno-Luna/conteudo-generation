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

import com.crudfarmacia.farmaciacrud.Model.Categoria;
import com.crudfarmacia.farmaciacrud.Repository.CategoriaRepository;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIDCategoria(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> findByDescricaoCategoria(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria salvar){
		return ResponseEntity.ok(repository.save(salvar));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria atualizar){
		return ResponseEntity.ok(repository.save(atualizar));
	}
	
	@DeleteMapping("/delete")
	public void deleteCategoria(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
