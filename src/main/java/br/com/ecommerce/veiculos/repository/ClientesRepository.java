package br.com.ecommerce.veiculos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.veiculos.model.Clientes;

/**
 * 
 * @author cesar
 * @date 21/04/2022
 * @version 0.0.1
 */

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>{
	
	public List<Clientes> findAllByNomeClienteContainingIgnoreCase (String nomeCliente);
	public Optional<Clientes> findByCpfCliente (String cpfCliente);
}
