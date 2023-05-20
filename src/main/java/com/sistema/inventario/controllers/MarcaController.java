package com.sistema.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.entidades.Categoria;
import com.sistema.inventario.entidades.Marca;
import com.sistema.inventario.entidades.Producto;
import com.sistema.inventario.service.MarcaService;

@Controller
public class MarcaController {

	@Autowired
	private MarcaService marcaServ;
	
	@Autowired
	private CategoriaDAO catDAO;
	
	
	@GetMapping("/marcas")
	public String listarMarcas(Model modelo) {
		
		List<Marca> marcas = marcaServ.obtenerTodosLasMarcas();
		
		modelo.addAttribute("marcas", marcas);
		
		return "marcas";
	}
	
	
	@GetMapping("/marcas/nuevaMarca")
	public String mostrarFormCrearMarca(Model modelo) {
		
		List<Categoria> listaCategorias = catDAO.findAll();
		
		modelo.addAttribute("listaCategorias", listaCategorias);
		modelo.addAttribute("marca", new Marca());
		
		return "formAgregarMarca";
	}
	
	@GetMapping("/marcas/editarForm")
	public String mostrarFormEditar(Model modelo, Marca marca) {

		List<Categoria> listaCategorias = catDAO.findAll();

		marca = marcaServ.findById(marca.getId());

		modelo.addAttribute("listaCategorias", listaCategorias);

		modelo.addAttribute("marca", marca);

		return "formAgregarMarca";
	}
	
	
	@PostMapping("/marcas/guardarMarca")
	public String guardarMarca(Model modelo, Marca marca) {
		
		marca = marcaServ.crearMarca(marca);
		modelo.addAttribute("marca", marca);
		
		return "redirect:/inicio";
	}
	
}
