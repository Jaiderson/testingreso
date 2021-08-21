package com.evertec.testingreso.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertec.testingreso.entities.OrdenCompra;
import com.evertec.testingreso.repositories.IOrdenCompraRep;
import com.evertec.testingreso.services.IOrdenCompraService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraServiceImp implements IOrdenCompraService{

	@Autowired
	private final IOrdenCompraRep ordenCompraRep;

	@Override
	public OrdenCompra buscarOrdenCompraById(Long idOrden) {
		return ordenCompraRep.findByIdOrden(idOrden);
	}

	@Override
	public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra) {
		OrdenCompra ordenCompraDb = buscarOrdenCompraById(ordenCompra.getIdOrden());
		if(null != ordenCompraDb) {
			return ordenCompraDb;
		}
		return ordenCompraRep.save(ordenCompra);
	}

	@Override
	public OrdenCompra modificarOrdenCompra(OrdenCompra ordenCompra) {
		OrdenCompra ordenCompraDb = buscarOrdenCompraById(ordenCompra.getIdOrden());
		if(null == ordenCompraDb) {
			return crearOrdenCompra(ordenCompra);
		}
		ordenCompra.setIdOrden(ordenCompraDb.getIdOrden());
		return ordenCompraRep.save(ordenCompra);
	}

	@Override
	public OrdenCompra eliminarOrdenCompra(Long idOrden) {
		OrdenCompra ordenCompraDb = buscarOrdenCompraById(idOrden);
		if(null == ordenCompraDb) {
			return null;
		}
		ordenCompraRep.delete(ordenCompraDb);
		return ordenCompraDb;
	}

	@Override
	public List<OrdenCompra> consultarOrdenesCompra() {
		return ordenCompraRep.findAll();
	}

}
