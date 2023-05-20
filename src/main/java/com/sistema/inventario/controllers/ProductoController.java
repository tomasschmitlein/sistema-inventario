package com.sistema.inventario.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.entidades.Categoria;
import com.sistema.inventario.entidades.Producto;
import com.sistema.inventario.service.ProductoService;

import jakarta.servlet.http.HttpServletRequest;

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

		return "formAgregarProducto";
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
	public String eliminarProducto(@PathVariable("id") Integer id, Model modelo) {

		Producto producto = pService.eliminarProducto(id);

		modelo.addAttribute("productoEliminado", producto);

		return "redirect:/productos";
	}

	@PostMapping("/productos/guardarProducto")
	public String guardarProducto(Model modelo, Producto nuevoProd, HttpServletRequest request) {

		//obtenemos los valores de los input del front, del form "agregarProducto", getparameterValues nos permite obtener los datos de una peticion get
		
		String[] detallesIDs = request.getParameterValues("detallesIDs");
		String[] detallesNombres = request.getParameterValues("detallesNombre");
		String[] detallesValores = request.getParameterValues("detallesValores");
		
		for(int i = 0; i< detallesNombres.length; i++) {
			
			//en caso que existan ya detalles
			if(detallesIDs != null && detallesIDs.length > 0) {
				
				nuevoProd.setDetalle(Integer.valueOf(detallesIDs[i]), detallesNombres[i], detallesValores[i]);
				
			}else { //si es un nuevo detalle
				nuevoProd.guardarDetalles(detallesNombres[i], detallesValores[i]);
			}
			
		}
		
		nuevoProd = pService.crearProducto(nuevoProd);

		modelo.addAttribute("nuevoProducto", nuevoProd);

		return "redirect:/inicio";

	}

}
