package br.com.ecommerce.veiculos.controller;

import java.util.List;

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

import br.com.ecommerce.veiculos.model.Categoria;
import br.com.ecommerce.veiculos.repository.CategoriaRepository;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.0.1
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodasCategorias() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarCategoriaId (@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> buscarCategoriaNome (@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Categoria> criarCategoria (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> atualizarCategoria (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deletarCategoria (@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
