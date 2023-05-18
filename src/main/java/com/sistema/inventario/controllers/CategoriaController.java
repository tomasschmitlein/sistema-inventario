package com.sistema.inventario.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.entidades.Categoria;

@Controller
public class CategoriaController {

	
	@Autowired
	private CategoriaDAO catDAO;
	
	
	@GetMapping("/categorias")
	public String listarCategorias(Model modelo) {
		
		List<Categoria> listaCat = catDAO.findAll();
		
		modelo.addAttribute("categorias", listaCat);
		
		return "categorias";
		
	}
	
	@GetMapping("/categorias/nuevaCat")
	public String mostrarFormAgregarCat(Model modelo) {
		
		//le pasamos un obj de categoria para que en el form a este obj le podamos agregar sus valores
		modelo.addAttribute("categoria", new Categoria());
		
		return "formAgregarCategoria";
		
	}
	
	@PostMapping("/categorias/guardarCategoria")
	public String guardarCategoria(Model modelo, Categoria nuevaCat) {
		
		nuevaCat = catDAO.save(nuevaCat);
		
		modelo.addAttribute("nuevaCategoria", nuevaCat);
		
		return "redirect:/inicio";
		
	}
	
	@GetMapping("/categorias/eliminar/{id}")
	public String eliminarCategoria(Categoria categoria) {
		
		catDAO.delete(categoria);
		
		return "redirect:/inicio";
		
	}
	
	@GetMapping("/categorias/editarForm")
	public String mostrarFormEditar(Model modelo, Categoria categoria) {
		
		categoria = catDAO.findById(categoria.getId()).orElse(null);
		
		modelo.addAttribute("categoria", categoria);
		
		return "formAgregarCategoria";
	}
	
	/*
	@PutMapping("/categorias/editar")
	public String editarCategoria(Model modelo, Categoria categoria) {
		
		categoria = catDAO.save(categoria);
		
		modelo.addAttribute("categoria", categoria);
		
		return "redirect:/categorias";
	}
	*/
}
