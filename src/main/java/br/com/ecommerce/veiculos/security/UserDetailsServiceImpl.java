package br.com.ecommerce.veiculos.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ecommerce.veiculos.model.Clientes;
import br.com.ecommerce.veiculos.repository.ClientesRepository;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.0.1
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClientesRepository repository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		
		Optional<Clientes> clientes = repository.findByCpfCliente(cpf);

		if (clientes.isPresent()) {
			return new UserDetailsImpl(clientes.get());
		}
		else {
			throw new UsernameNotFoundException("Usuário Não Existe!");
		}
		
	}

}
