package br.com.ecommerce.veiculos.controller;

import java.util.List;

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

import br.com.ecommerce.veiculos.dto.ClientesCredenciaisDTO;
import br.com.ecommerce.veiculos.dto.ClientesDTO;
import br.com.ecommerce.veiculos.dto.ClientesLoginDTO;
import br.com.ecommerce.veiculos.model.Clientes;
import br.com.ecommerce.veiculos.service.ClientesService;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.0.1
 */
@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClientesController {

	@Autowired
	ClientesService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Clientes> cadastrar (@RequestBody Clientes clientes) {
		return service.cadastrar(clientes);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ClientesCredenciaisDTO> login (@Valid @RequestBody ClientesLoginDTO clientes) {
		return service.login(clientes);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientesDTO>> getAllClientes () {
		return service.getAllClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> getClienteById (@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ClientesDTO>> getClienteByNome (@PathVariable String nome) {
		return service.buscarPorNome(nome);
	}
	
	@PutMapping
	public ResponseEntity<ClientesDTO> atualizarCliente (@RequestBody Clientes cliente) {
		return service.atualizar(cliente);
	}
		
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable long id) {
		service.deletarClientes(id);
	}
}
