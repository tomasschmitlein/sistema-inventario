package com.sistema.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.entidades.Categoria;
import com.sistema.inventario.entidades.Producto;
import com.sistema.inventario.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService pService;

	@Autowired
	private CategoriaDAO catDAO;

	@GetMapping("/productos")
	public String mostrarProductos(Model modelo) {

		List<Producto> productos = pService.obtenerTodosLosProductos();

		modelo.addAttribute("productos", productos);

		return "productos";
	}

	@GetMapping("/productos/editarForm")
	public String mostrarFormEditar(Model modelo, Producto prod) {

		List<Categoria> categorias = catDAO.findAll();

		prod = pService.findById(prod.getId());

		modelo.addAttribute("producto", prod);

		modelo.addAttribute("categorias", categorias);

		return "formEditarProducto";
	}

	@GetMapping("/productos/nuevoProd")
	public String mostrarFormAgregarProd(Model modelo) {

		List<Categoria> categorias = catDAO.findAll();

		// le pasamos un obj de producto para que en el form a este obj le podamos
		// agregar sus valores
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("categorias", categorias);

		return "formAgregarProducto";

	}

	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable Integer id, Model modelo) {

		Producto producto = pService.eliminarProducto(id);

		modelo.addAttribute("productoEliminado", producto);

		return "redirect:/productos";
	}

	@PostMapping("/productos/guardarProducto")
	public String guardarProducto(Model modelo, Producto nuevoProd) {

		nuevoProd = pService.crearProducto(nuevoProd);

		modelo.addAttribute("nuevoProducto", nuevoProd);

		return "redirect:/inicio";

	}

}
