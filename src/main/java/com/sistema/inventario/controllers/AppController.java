package com.sistema.inventario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/inicio")
	public String verPaginaDeInicio() {
		
		return "index";
		
	}
	
}
