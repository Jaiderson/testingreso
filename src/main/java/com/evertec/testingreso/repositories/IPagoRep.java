package com.evertec.testingreso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evertec.testingreso.entities.Pago;

@Repository
public interface IPagoRep extends JpaRepository<Pago, Long>{

	/**
	 * Busca un pago de una orden de compra dado el id del pago <b>idPago</b>
	 * 
	 * @param idPago Id del pago.
	 * @return Null si no se encuentra el pago, en caso contrario el pago asociado a la orden de compra.
	 */
	public Pago findByIdPago(Long idPago);

	/**
	 * Busca todos los pagos
	 * 
	 * @return Lista vacia si no se encuentra pagos, en caso contrario listado de todos los pagos.
	 */
	public List<Pago> findAll();

}
