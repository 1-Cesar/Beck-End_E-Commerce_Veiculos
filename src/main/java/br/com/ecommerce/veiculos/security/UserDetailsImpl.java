package br.com.ecommerce.veiculos.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ecommerce.veiculos.model.Clientes;

/**
 * @date 22/04/2022
 * @author cesar
 * @version 0.0.1
 */

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private String cpf;	
	private String senha;	

	public UserDetailsImpl(Clientes clientes) {
		
		this.cpf = clientes.getCpfCliente();		
		this.senha = clientes.getSenhaCliente();
		
	}
	
	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cpf;
	}	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
