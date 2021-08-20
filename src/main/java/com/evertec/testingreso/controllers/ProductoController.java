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

import com.evertec.testingreso.entities.Producto;
import com.evertec.testingreso.services.IProductoService;

@Controller
@RequestMapping
public class ProductoController {

	@Autowired
	private IProductoService productoServ;

	@GetMapping("/listarProductos")
	public String listarProductos(Model model) {
	    List<Producto> productos = productoServ.consultarProductos();
		model.addAttribute("productos", productos);
	    
		return "indexProducto";
	}

	@GetMapping("/nuevoProducto")
	public String crearProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "formProducto";
	}

	@PostMapping("/guardarProducto")
	public String guardarProducto(@Valid Producto producto, Model model) {
		productoServ.modificarProducto(producto);
		return "redirect:/listarProductos";
	}

	@GetMapping("/editarProducto/{idProducto}")
	public String editarProducto(@PathVariable long idProducto, Model model) {
		Producto productoDb = productoServ.buscarProductoById(idProducto);
		if(null == productoDb) {
			return "listarProductos";
		}
		model.addAttribute("producto", productoDb);
		return "formProducto";
	}

	@GetMapping("/eliminarProducto/{idProducto}")
	public String eliminarProducto(@PathVariable long idProducto, Model model) {
		productoServ.eliminarProducto(idProducto);
		return "redirect:/listarProductos";
	}

}
