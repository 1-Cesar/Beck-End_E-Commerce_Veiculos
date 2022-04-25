package br.com.ecommerce.veiculos.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ecommerce.veiculos.dto.ClientesCredenciaisDTO;
import br.com.ecommerce.veiculos.dto.ClientesDTO;
import br.com.ecommerce.veiculos.dto.ClientesLoginDTO;
import br.com.ecommerce.veiculos.model.Clientes;
import br.com.ecommerce.veiculos.repository.ClientesRepository;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.0.1
 */
@Service
public class ClientesService {

	private ClientesCredenciaisDTO credenciaisDTO;
	
	@Autowired
	private ClientesRepository repository;
	
	public ResponseEntity<Clientes> cadastrar (Clientes novoClientes) {
		
		Optional<Clientes> optional = repository.findByCpfCliente(novoClientes.getCpfCliente());
		
		if (optional.isEmpty()) {
			novoClientes.setSenhaCliente(criptografarSenha(novoClientes.getSenhaCliente()));
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoClientes));
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado!");
		}
	}
	
	private String criptografarSenha (String senhaCliente) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senhaCliente);
	}
	
	public ClientesDTO modelParaDTO (Clientes Clientes) {
		
		ClientesDTO dto = new ClientesDTO();
		
		dto.setId(Clientes.getIdCliente());
		dto.setCpf(Clientes.getCpfCliente());
		dto.setBairro(Clientes.getBairroCliente());
		dto.setCep(Clientes.getCepCliente());
		dto.setCidade(Clientes.getCidadeCliente());
		dto.setEmail(Clientes.getEmailCliente());
		dto.setEndereco(Clientes.getEnderecoCliente());
		dto.setNome(Clientes.getNomeCliente());
		dto.setTelefone(Clientes.getTelefoneCliente());
		dto.setUf(Clientes.getUfCliente());
		
		return dto;
	}
	
	private String basicTokenGenerator(String cpf, String senha) {
		
		String structure = cpf + ":" + senha;
		
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		
		return "Basic " + new String(structureBase64);
		
	}
	
	public ResponseEntity<List<ClientesDTO>> getAllClientes() {
		
		List<Clientes> Clientes = repository.findAll();		
		List<ClientesDTO> ClientesDTOs = new ArrayList<>();
		
		for (Clientes Cliente : Clientes) {			
			ClientesDTOs.add(modelParaDTO(Cliente));			
		}
		
		if (Clientes.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(ClientesDTOs);
		}
	}
	
	public ResponseEntity<Clientes> buscarPorId(Long id) {
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não Encontrado!");
				});
		
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity deletarClientes (Long id) {
		
		Optional<Clientes> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.status(200).build();
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não Encontrado!");
		}
		
	}
	
	public ResponseEntity<List<ClientesDTO>> buscarPorNome(String nome) {
		
		List<Clientes> Clientes = repository.findAllByNomeClienteContainingIgnoreCase(nome);
		List<ClientesDTO> ClientesDTOs = new ArrayList<>();
		
		for (Clientes Cliente : Clientes) {
			ClientesDTOs.add(modelParaDTO(Cliente));
		}
		
		if (Clientes.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(ClientesDTOs);
		}
		
	}
	
	public ResponseEntity<ClientesCredenciaisDTO> login (@Valid ClientesLoginDTO dto) {	
		
		return repository.findByCpfCliente(dto.getCpf()).map(resp -> {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if (encoder.matches(dto.getSenha(), resp.getSenhaCliente())) {				
				credenciaisDTO = new ClientesCredenciaisDTO(
						basicTokenGenerator(dto.getCpf(), dto.getSenha()),
						resp.getIdCliente(),
						resp.getCpfCliente(),
						resp.getNomeCliente());				
				return ResponseEntity.status(HttpStatus.OK).body(credenciaisDTO);
			} 
			else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha Inválida!");
			}
			
		}).orElseThrow(() -> {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe!");			
		});
		
	}
	
	public ResponseEntity<ClientesDTO> atualizar (Clientes modificado) {
		
		Optional<Clientes> optional = repository.findById(modificado.getIdCliente());
		
		if(optional.isPresent()) {
			modificado.setSenhaCliente(criptografarSenha(modificado.getSenhaCliente()));
			return ResponseEntity.status(200).body(modelParaDTO(repository.save(modificado)));
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id Não Encontrado!");
		}
	}
	
}
