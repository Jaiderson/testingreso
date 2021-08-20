package com.evertec.testingreso.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evertec.testingreso.entities.Producto;

@Service
public interface IProductoService {

	/**
	 * Busca un producto dado su identificador <b>idProducto</b>
	 * 
	 * @param idProducto Id del producto.
	 * @return Null si no se encuentra, en caso contrario el Producto.
	 */
	public Producto buscarProductoById(Long idProducto);

	/**
	 * Busca un producto dado su codigo <b>codProducto</b>
	 * 
	 * @param codProducto Codigo del producto.
	 * @return Null si no se encuentra, en caso contrario el producto.
	 */
	public Producto buscarProductoByCodigo(String codProducto);

	/**
	 * Crea un producto nuevo en la base de datos, si ya existe retorne el existente.
	 * 
	 * @param producto Producto a registrar
	 * @return Nuevo producto o si ya existe el existente. 
	 */
	public Producto crearProducto(Producto producto);

	/**
	 * Modifica un producto existente en la base de datos.
	 * 
	 * @param producto Producto a actualizar.
	 * @return Producto actualizado o null si no existe. 
	 */
	public Producto modificarProducto(Producto producto);

	/**
	 * Elimina un producto existente en la base de datos.
	 * 
	 * @param idProducto Id producto a eliminar.
	 * @return Producto eliminado o null si no existe. 
	 */
	public Producto eliminarProducto(Long idProducto);

	/**
	 * Busca los productos cuyo nombre contenga <b>nomProducto</b>
	 * 
	 * @param nomProducto Nombre del producto.
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de productos.
	 */
	public List<Producto> consultarProductos(String nomProducto);

	/**
	 * Busca todos los productos.
	 * 
	 * @return Lista vacia si no se encuentra nada, en caso contrario el listado de productos.
	 */
	public List<Producto> consultarProductos();

}
