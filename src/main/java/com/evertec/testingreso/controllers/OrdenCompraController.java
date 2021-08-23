package com.evertec.testingreso.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evertec.testingreso.entities.OrdenCompra;
import com.evertec.testingreso.services.IOrdenCompraService;

@Controller
@RequestMapping
public class OrdenCompraController {

	@Autowired
	private IOrdenCompraService ordenCompraServ;

	@GetMapping("/listarOrdenes")
	public String listarOrdenesCompra(Model model) {
	    List<OrdenCompra> ordenesCompra = ordenCompraServ.consultarOrdenesCompra();
		model.addAttribute("ordenesCompra", ordenesCompra);
	    
		return "indexOrdenCompra";
	}

	@GetMapping("/nuevaOrden")
	public String crearOrdenCompra(Model model) {
		model.addAttribute("ordenCompra", new OrdenCompra());
		return "formOrdenCompra";
	}

	@PostMapping("/guardarOrden")
	public String guardarOrdenCompra(@Valid OrdenCompra ordenCompra, Model model) {
		ordenCompraServ.modificarOrdenCompra(ordenCompra);
		return "redirect:/listarOrdenes";
	}

	@GetMapping("/editarOrden/{idOrden}")
	public String editarOrdenCompra(@PathVariable long idOrden, Model model) {
		OrdenCompra ordenCompraDb = ordenCompraServ.buscarOrdenCompraById(idOrden);
		if(null == ordenCompraDb) {
			return "listarOrdenes";
		}
		model.addAttribute("ordenCompra", ordenCompraDb);
		return "formOrdenCompra";
	}

	@GetMapping("/eliminarOrden/{idOrden}")
	public String eliminarOrdenCompra(@PathVariable long idOrden, Model model) {
		ordenCompraServ.eliminarOrdenCompra(idOrden);
		return "redirect:/listarOrdenes";
	}

	@GetMapping("/pagarOrden/{idOrden}")
	public String pagarOrdenCompra(@PathVariable long idOrden, Model model) {
		
		return "redirect:/listarProductos";
	}

}
