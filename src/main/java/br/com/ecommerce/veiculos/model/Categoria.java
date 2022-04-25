package br.com.ecommerce.veiculos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table (name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull
	@Size (min = 3, max = 16)
	private String nomeCategoria;
	
	@OneToMany (mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Veiculos> veiculos;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}	
	
}
