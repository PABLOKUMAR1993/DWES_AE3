package com.edix.cuenta.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {	
	
	/**
	 * Método que captura el acceso a la web y muestra la página de inicio.
	 */
	@GetMapping( "/" )
	public String inicio() { return "index"; }
	
}
