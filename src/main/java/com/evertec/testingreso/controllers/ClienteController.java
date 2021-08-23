package com.evertec.testingreso.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.evertec.testingreso.entities.Cliente;
import com.evertec.testingreso.services.IClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteServ;

	@GetMapping("/listarClientes")
	public String listarClientes(Model model) {
	    List<Cliente> clientes = clienteServ.consultarClientes();
		model.addAttribute("clientes", clientes);
	    
		return "indexCliente";
	}

	@GetMapping("/listarClientesPorNombre/{nomCliente}")
	public String listarClientesPorNombre(@PathVariable String nomCliente, Model model) {
	    List<Cliente> clientes = clienteServ.buscarClientesPorNombre(nomCliente);
		model.addAttribute("clientes", clientes);
		
		return "formOrdenCompra";
	}

	@GetMapping("/nuevoCliente")
	public String crearCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "formCliente";
	}

	@PostMapping("/guardarCliente")
	public String guardarCliente(@Valid Cliente cliente, Model model) {
		clienteServ.modificarCliente(cliente);
		return "redirect:/listarClientes";
	}

	@GetMapping("/editarCliente/{idCliente}")
	public String editarCliente(@PathVariable long idCliente, Model model) {
		Cliente clienteDb = clienteServ.buscarClienteById(idCliente);
		if(null == clienteDb) {
			return "listarClientes";
		}
		model.addAttribute("cliente", clienteDb);
		return "formCliente";
	}

	@GetMapping("/eliminarCliente/{idCliente}")
	public String eliminarCliente(@PathVariable long idCliente, Model model) {
		clienteServ.eliminarCliente(idCliente);
		return "redirect:/listarClientes";
	}

	@GetMapping(value = "/{idCliente}")
	public ResponseEntity<Cliente> buscarProducto(@PathVariable("idCliente") Long idCliente){
		Cliente cliente = clienteServ.buscarClienteById(idCliente);
		if(null == cliente) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente "+idCliente+" no encontrado.");
		}
		return ResponseEntity.ok(cliente);
	}
}
