package com.evertec.testingreso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.evertec.testingreso.entities.Cliente;

@Repository
public interface IClienteRep extends JpaRepository<Cliente, Long>{

	/**
	 * Busca un Cliente dado su identificador <b>idCliente</b>
	 * 
	 * @param idCliente Id del cliente.
	 * @return Null si no se encuentra, en caso contrario el cliente.
	 */
	public Cliente findByIdCliente(Long idCliente);

	/**
	 * Busca los clientes cuyo nombre contenga <b>nomCliente</b>
	 * 
	 * @param nomCliente Nombre del cliente.
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de clientes.
	 */
	public List<Cliente> findByNombre(String nomCliente);

}
