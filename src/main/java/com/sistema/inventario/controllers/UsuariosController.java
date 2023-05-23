package com.sistema.inventario.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.entidades.Rol;
import com.sistema.inventario.entidades.Usuario;
import com.sistema.inventario.service.RolService;
import com.sistema.inventario.service.UsuarioService;

@Controller
public class UsuariosController {

	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private RolService rolService;

	@GetMapping("/usuarios")
	public String listarMarcas(Model modelo) {

		List<Usuario> usuarios = userService.obtenerTodosLosUsuario();

		modelo.addAttribute("usuarios", usuarios);

		return "usuarios";
	}

	@GetMapping("/usuarios/nuevoUsuario")
	public String mostrarFormCrearUsuario(Model modelo) {

		List<Rol> listaRol = rolService.obtenerTodosLosRoles();

		modelo.addAttribute("listaRoles", listaRol);
		modelo.addAttribute("usuario", new Usuario());

		return "formAgregarUsuario";
	}

	@GetMapping("/usuarios/editarForm")
	public String mostrarFormEditar(Model modelo, Usuario user) {

		List<Rol> listaRol = rolService.obtenerTodosLosRoles();

		user = userService.findById(user.getId());

		modelo.addAttribute("listaRoles", listaRol);
		modelo.addAttribute("usuario", user);

		return "formAgregarUsuario";
	}
	
	@GetMapping("/usuarios/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id, Model modelo) {

		Usuario user = userService.eliminarUsuario(id);

		modelo.addAttribute("userEliminado", user);

		return "redirect:/usuarios";
	}

	@PostMapping("/usuarios/guardarUsuario")
	public String guardarMarca(Model modelo, Usuario user) {

		user = userService.crearUsuario(user);
		modelo.addAttribute("usuario", user);

		return "redirect:/inicio";
	}

}
