package com.evertec.testingreso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evertec.testingreso.entities.OrdenCompra;

@Repository
public interface IOrdenCompraRep extends JpaRepository<OrdenCompra, Long>{

	/**
	 * Busca una orden de compra dado su identificador <b>idOrden</b>
	 * 
	 * @param idOrden Id de la orden de compra.
	 * @return Null si no se encuentra, en caso contrario la orden de compra.
	 */
	public OrdenCompra findByIdOrden(Long idOrden);

	/**
	 * Busca todas las ordenes de compra.
	 * 
	 * @return Lista vacia si no se encuentra ordenes de compra, en caso contrario el listado de ordenes de compra.
	 */
	public List<OrdenCompra> findByAll();

}
