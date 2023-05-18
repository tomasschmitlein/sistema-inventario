package com.sistema.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.entidades.Categoria;
import com.sistema.inventario.entidades.Marca;
import com.sistema.inventario.service.MarcaService;

@Controller
public class MarcaController {

	@Autowired
	private MarcaService marcaServ;
	
	@Autowired
	private CategoriaDAO catDAO;
	
	@GetMapping("/marcas/nueva")
	public String mostrarFormCrearMarca(Model modelo) {
		
		List<Categoria> listaCategorias = catDAO.findAll();
		
		modelo.addAttribute("categorias", listaCategorias);
		modelo.addAttribute("marca", new Marca());
		
		return "formAgregarMarca";
	}
	
}
