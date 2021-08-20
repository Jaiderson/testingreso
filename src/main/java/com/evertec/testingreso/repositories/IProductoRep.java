package com.evertec.testingreso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evertec.testingreso.entities.Producto;

@Repository
public interface IProductoRep extends JpaRepository<Producto, Long>{

	/**
	 * Busca un producto dado su identificador <b>idProducto</b>
	 * 
	 * @param idProducto Id del producto.
	 * @return Null si no se encuentra, en caso contrario el Producto.
	 */
	public Producto findByIdProducto(Long idProducto);

	/**
	 * Busca un producto dado su codigo <b>codProducto</b>
	 * 
	 * @param codProducto Codigo del producto.
	 * @return Null si no se encuentra, en caso contrario el producto.
	 */
	public Producto findByCodProducto(String codProducto);

	/**
	 * Busca los productos cuyo nombre contenga <b>nomProducto</b>
	 * 
	 * @param nomProducto Nombre del producto.
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de productos.
	 */
	public List<Producto> findByNombre(String nomProducto);

}
