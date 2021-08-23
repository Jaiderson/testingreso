package com.evertec.testingreso.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertec.testingreso.entities.Cliente;
import com.evertec.testingreso.repositories.IClienteRep;
import com.evertec.testingreso.services.IClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements IClienteService{

	@Autowired
	private final IClienteRep clienteRep;

	@Override
	public Cliente buscarClienteById(Long idCliente) {
		return clienteRep.findByIdCliente(idCliente);
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		Cliente clienteDb = buscarClienteById(cliente.getIdCliente());
		if(null != clienteDb) {
			return clienteDb;
		}
		return clienteRep.save(cliente);
	}

	@Override
	public Cliente modificarCliente(Cliente cliente) {
		Cliente clienteDb = buscarClienteById(cliente.getIdCliente());
		if(null == clienteDb) {
			return crearCliente(cliente);
		}
		cliente.setIdCliente(clienteDb.getIdCliente());
		return clienteRep.save(cliente);
	}

	@Override
	public Cliente eliminarCliente(Long idCliente) {
		Cliente clienteDb = buscarClienteById(idCliente);
		if(null == clienteDb) {
			return null;
		}
		clienteRep.delete(clienteDb);
		return clienteDb;
	}

	@Override
	public List<Cliente> consultarClientes() {
		return clienteRep.findAll();
	}

	@Override
	public List<Cliente> consultarClientes(String nomCliente) {
		return clienteRep.findByNombre(nomCliente);
	}

	@Override
	public List<Cliente> buscarClientesPorNombre(String nomCliente) {
		return clienteRep.findByKeyword(nomCliente);
	}

}
