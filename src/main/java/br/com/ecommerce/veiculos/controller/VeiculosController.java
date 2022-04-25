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

import br.com.ecommerce.veiculos.model.Veiculos;
import br.com.ecommerce.veiculos.repository.VeiculosRepository;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.01
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/veiculos")
public class VeiculosController {

	@Autowired
	private VeiculosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Veiculos>> buscarTodosVeiculos() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculos> buscarVeiculosId (@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Veiculos>> buscarVeiculoNome (@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeVeiculoContainingIgnoreCase(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Veiculos> post(@RequestBody Veiculos veiculos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(veiculos));
	}
	
	@PutMapping
	public ResponseEntity<Veiculos> atualizarVeiculo (@RequestBody Veiculos veiculos) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(veiculos));
	}
	
	@DeleteMapping("/{id}")
	public void deletarVeiculo (@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
