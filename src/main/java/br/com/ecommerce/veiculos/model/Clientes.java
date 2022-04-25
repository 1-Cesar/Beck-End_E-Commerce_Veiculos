package br.com.ecommerce.veiculos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author cesar
 * @date 21/04/2022 
 * @version 0.0.1
 */

@Entity
@Table(name = "tb_clientes")
public class Clientes {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@NotNull
	@Size (min = 3, max = 100)
	private String cpfCliente;
	
	@NotNull
	@Size (min = 3, max = 100)
	private String nomeCliente;
	
	@NotNull
	@Size(min = 10, max = 17)
	private String telefoneCliente;	
	
	@NotNull
	@Size(min = 3, max = 100)
	private String enderecoCliente;
	
	@NotNull
	@Size(min = 8, max = 9)
	private String cepCliente;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String cidadeCliente;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String bairroCliente;
	
	@NotNull
	@Size(min = 2, max = 2)
	private String ufCliente;
	
	@Email
	@NotNull
	@Size(min = 10, max = 100)
	private String emailCliente;
	
	//alterar quando estiver tudo pronto
	@NotNull	
	@Size(min = 8, max = 255)
	private String senhaCliente;
	
	@OneToMany(mappedBy = "clientes", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("clientes")
	private List<Veiculos> veiculos;
		
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getUfCliente() {
		return ufCliente;
	}

	public void setUfCliente(String ufCliente) {
		this.ufCliente = ufCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
