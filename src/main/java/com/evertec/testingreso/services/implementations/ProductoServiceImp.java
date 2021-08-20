package com.evertec.testingreso.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertec.testingreso.entities.Producto;
import com.evertec.testingreso.repositories.IProductoRep;
import com.evertec.testingreso.services.IProductoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImp implements IProductoService{

	@Autowired
	private final IProductoRep productoRep;
	
	@Override
	public Producto buscarProductoById(Long idProducto) {
		return productoRep.findByIdProducto(idProducto);
	}

	@Override
	public Producto buscarProductoByCodigo(String codProducto) {
		return productoRep.findByCodProducto(codProducto);
	}
	@Override
	public Producto crearProducto(Producto producto) {
		return productoRep.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		Producto productoDb = productoRep.findByCodProducto(producto.getCodProducto());
		if(null == productoDb) {
			return crearProducto(producto);
		}
		producto.setIdProducto(productoDb.getIdProducto());
		return productoRep.save(producto);
	}

	@Override
	public Producto eliminarProducto(Long idProducto) {
		Producto productoDb = buscarProductoById(idProducto);
		if(null == productoDb) {
			return null;
		}
		productoRep.delete(productoDb);
		return productoDb;
	}

	@Override
	public List<Producto> consultarProductos(String nomProducto) {
		return productoRep.findByNombre(nomProducto);
	}

	@Override
	public List<Producto> consultarProductos() {
		return productoRep.findAll();
	}

}
