package br.com.ecommerce.veiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author cesar
 * @date 21/04/2022
 * @version 0.0.1
 */

@Entity
@Table (name ="tb_veiculos")
public class Veiculos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idVeiculos;
	
	@NotNull
	@Size (min = 2, max = 50)
	private String marcaVeiculo;
	
	@NotNull
	@Size (min = 4, max = 50)
	private String nomeVeiculo;
	
	@NotNull
	@Size (min = 4, max = 50)
	private String modeloVeiculo;
	
	@NotNull
	@Size (min = 13, max = 17)
	private String chassiVeiculo;
	
	@NotNull
	private Boolean completoVeiculo;
	
	@NotNull
	@Size (min = 2, max = 4)
	private String anoVeiculo;
	
	@NotNull
	@Size (min = 3, max = 8)
	private String combustivelVeiculo;
	
	@NotNull
	@Size (min = 3, max = 5)
	private String potenciaVeiculo;	
	
	@ManyToOne
	@JsonIgnoreProperties("veiculos")
	private Clientes clientes;
	
	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("veiculos")
	private Categoria categoria;

	public Long getIdVeiculos() {
		return idVeiculos;
	}

	public void setIdVeiculos(Long idVeiculos) {
		this.idVeiculos = idVeiculos;
	}

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getChassiVeiculo() {
		return chassiVeiculo;
	}

	public void setChassiVeiculo(String chassiVeiculo) {
		this.chassiVeiculo = chassiVeiculo;
	}

	public Boolean getCompletoVeiculo() {
		return completoVeiculo;
	}

	public void setCompletoVeiculo(Boolean completoVeiculo) {
		this.completoVeiculo = completoVeiculo;
	}

	public String getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(String anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public String getCombustivelVeiculo() {
		return combustivelVeiculo;
	}

	public void setCombustivelVeiculo(String combustivelVeiculo) {
		this.combustivelVeiculo = combustivelVeiculo;
	}

	public String getPotenciaVeiculo() {
		return potenciaVeiculo;
	}

	public void setPotenciaVeiculo(String potenciaVeiculo) {
		this.potenciaVeiculo = potenciaVeiculo;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
	
}
