package com.evertec.testingreso.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evertec.testingreso.entities.OrdenCompra;

@Repository
public interface IOrdenCompraService {

	/**
	 * Busca una orden de compra dado su identificador <b>idOrden</b>
	 * 
	 * @param idOrden Id de la orden de comprqa.
	 * @return Null si no se encuentra, en caso contrario orden de compra.
	 */
	public OrdenCompra buscarOrdenCompraById(Long idOrden);

	/**
	 * Crea una orden de compra nuevo en la base de datos, si ya existe retorna la existente.
	 * 
	 * @param ordenCompra Orden de compra a registrar
	 * @return Nueva orden de compra o si ya existe retorna el existente. 
	 */
	public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra);

	/**
	 * Modifica una orden de compra existente en la base de datos.
	 * 
	 * @param ordenCompra orden de compra a actualizar.
	 * @return Orden de compra Actualizado o null si no existe. 
	 */
	public OrdenCompra modificarOrdenCompra(OrdenCompra ordenCompra);

	/**
	 * Elimina una orden de compra existente en la base de datos.
	 * 
	 * @param idOrden Id orden de compram a eliminar.
	 * @return Orden de compraEliminado o null si no existe. 
	 */
	public OrdenCompra eliminarOrdenCompra(Long idOrden);

	/**
	 * Busca todos las ordenes de compra registradas.
	 * 
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de ordenes de compra.
	 */
	public List<OrdenCompra> consultarOrdenesCompra();

}
