package com.evertec.testingreso.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evertec.testingreso.entities.Pago;

@Repository
public interface IPagoService {

	/**
	 * Busca un pago dado su identificador <b>idPago</b>
	 * 
	 * @param idPago Id del pago.
	 * @return Null si no se encuentra, en caso contrario el pago.
	 */
	public Pago buscarPagoById(Long idPago);

	/**
	 * Crea un pago nuevo en la base de datos, si ya existe retorna el existente.
	 * 
	 * @param pago Pago a registrar
	 * @return Nuevo pago o si ya existe retorna el existente. 
	 */
	public Pago crearPago(Pago pago);

	/**
	 * Modifica un pago existente en la base de datos.
	 * 
	 * @param pago Pago a actualizar.
	 * @return pago Actualizado o null si no existe. 
	 */
	public Pago modificarPago(Pago pago);

	/**
	 * Elimina un pago existente en la base de datos.
	 * 
	 * @param idPago Id pago a eliminar.
	 * @return pago Eliminado o null si no existe. 
	 */
	public Pago eliminarPago(Long idPago);

	/**
	 * Busca todos los pagos.
	 * 
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de pagos.
	 */
	public List<Pago> consultarPagos();

}
