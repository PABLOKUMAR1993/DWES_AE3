package com.edix.cuenta.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.edix.cuenta.modelo.beans.Cuenta;
import com.edix.cuenta.modelo.dao.CuentaDaoInt;


@Controller
public class LoginController {

	
	// Atributos
	
	
	@Autowired
	private CuentaDaoInt cuentaDao;
	
	
	// Métodos
	
	
	/**
	 * Este método recibe un número de cuenta y comprueba si existe.
	 * Si existe la cuenta muestra la página principal y crea una variable de tipo sesión con la cuenta.
	 * Si no existe, crea un mensaje de tipo Model con el error y muestra index nuevamente.
	 */
	@GetMapping( "/identificacion" )
	public String iniciarSesion( Model model, HttpSession sesion, @RequestParam( "idCuenta" ) int idCuenta ) {
		
		boolean comprobar = cuentaDao.comprobarCuenta( idCuenta );
		
		if( comprobar ) {			
			Cuenta cuenta = cuentaDao.buscarUna( idCuenta );
			sesion.setAttribute("cuenta", cuenta);
			return "principal";
		} else {
			model.addAttribute("errorIniciarSesion", "El número de cuenta introducido no existe.");
			return "index";
		}
		
	}
	
	
}
