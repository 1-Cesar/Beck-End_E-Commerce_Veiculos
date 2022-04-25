package br.com.ecommerce.veiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.veiculos.model.Veiculos;

/**
 * 
 * @author cesar
 * @date 21/04/2022
 * @version 0.0.1
 */

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {

	public List<Veiculos> findAllByNomeVeiculoContainingIgnoreCase (String nomeVeiculo);
	
	
}
