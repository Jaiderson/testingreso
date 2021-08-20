package com.evertec.testingreso.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evertec.testingreso.entities.Cliente;

@Repository
public interface IClienteService {

	/**
	 * Busca un cliente dado su identificador <b>idCliente</b>
	 * 
	 * @param idcliente Id del cliente.
	 * @return Null si no se encuentra, en caso contrario el cliente.
	 */
	public Cliente buscarClienteById(Long idCliente);

	/**
	 * Crea un cliente nuevo en la base de datos, si ya existe retorne el existente.
	 * 
	 * @param cliente Cliente a registrar
	 * @return Nuevo cliente o si ya existe el existente. 
	 */
	public Cliente crearCliente(Cliente cliente);

	/**
	 * Modifica un cliente existente en la base de datos.
	 * 
	 * @param cliente Cliente a actualizar.
	 * @return cliente actualizado o null si no existe. 
	 */
	public Cliente modificarCliente(Cliente cliente);

	/**
	 * Elimina un cliente existente en la base de datos.
	 * 
	 * @param idCliente Id cliente a eliminar.
	 * @return cliente eliminado o null si no existe. 
	 */
	public Cliente eliminarCliente(Long idCliente);

	/**
	 * Busca los clientes cuyo nombre contenga <b>nomCliente</b>
	 * 
	 * @param nomCliente Nombre del cliente.
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de clientes.
	 */
	public List<Cliente> consultarClientes(String nomCliente);

	/**
	 * Busca todos los clientes.
	 * 
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de clientes.
	 */
	public List<Cliente> consultarClientes();

}
