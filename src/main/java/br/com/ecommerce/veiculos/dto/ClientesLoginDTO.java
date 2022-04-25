package br.com.ecommerce.veiculos.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author cesar
 * @date 22/04/2022
 * @version 0.0.1
 */

public class ClientesLoginDTO {

	@NotNull
	private String cpf;	
	
	@NotBlank
	private String senha;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
