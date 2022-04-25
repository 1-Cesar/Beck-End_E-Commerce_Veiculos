package br.com.ecommerce.veiculos.dto;

/**
 * 
 * @author cesar
 * @date 22/04/2022
 * @version 0.0.1
 */
public class ClientesCredenciaisDTO {

	private String basicToken;
	private Long id;
	private String cpf;
	private String nome;	
	private String email;
	
	public ClientesCredenciaisDTO(String basicToken, Long id, String cpf, String nome) {
		this.basicToken = basicToken;
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;		
	}

	public String getBasicToken() {
		return basicToken;
	}

	public void setBasicToken(String basicToken) {
		this.basicToken = basicToken;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}			
		
}


