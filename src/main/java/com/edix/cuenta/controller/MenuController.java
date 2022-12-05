package com.edix.cuenta.controller;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.edix.cuenta.modelo.beans.Cuenta;
import com.edix.cuenta.modelo.beans.Movimiento;
import com.edix.cuenta.modelo.dao.CuentaDaoInt;
import com.edix.cuenta.modelo.dao.MovimientoDaoInt;


@Controller
public class MenuController {

	
	// Atributos.
	
	@Autowired
	private MovimientoDaoInt movimientoDao;
	
	@Autowired
	private CuentaDaoInt cuentaDao;
	
	
	// Métodos.
	
	
	/**
	 * Método que captura el acceso a /menú y muestra la página de menú.
	 */
	@GetMapping( "/menu" )
	public String abrirMenu() { return "principal"; }
	
	
	/**
	 * Método que recupera los movimientos de la cuenta indicada.
	 * Recupera la cuenta que ha iniciado sesión, seguidamente llama a un método que devuelva la lista
	 * de los movimientos filtrados por cuenta, finalmente los almacena en una variable de tipo Model
	 * y se muestran en la página.
	 */
	@GetMapping( "/movimientos" )
	public String verMovimientos( HttpSession sesion, Model model ) {
		
		Cuenta cuenta = (Cuenta) sesion.getAttribute( "cuenta" );
		List<Movimiento> listaMovimientos = movimientoDao.buscarMovimientosPorCuenta( cuenta.getIdCuenta() );
		model.addAttribute( "listadoMovimientos", listaMovimientos );
		
		return "movimientos";
		
	}
	
	
	/**
	 * Método que muestra la página de hacer ingresos.
	 */
	@GetMapping( "/ingresar" )
	public String ingresar() { return "ingresar"; }
	
	
	/**
	 * Este método recupera la cuenta que ha iniciado sesión e intenta hacer un ingreso de la cantidad
	 * indicada en la cuenta loggeada.
	 * Si es exitoso muestra un mensaje por pantalla, si no, muestra otro mensaje con el error. 
	 */
	@PostMapping( "/ingreso" )
	public String hacerIngreso( Model model, HttpSession sesion, @RequestParam( "cantidad" ) double cantidad ) {
		
		Cuenta cuenta = (Cuenta) sesion.getAttribute( "cuenta" );
		
		if( movimientoDao.ingresar( cuenta, cantidad ) ) {
			model.addAttribute("mensajeIngreso", "Ingreso Realizado con Éxito");
			return "ingresar";
		} else {
			model.addAttribute("mensajeErrorIngreso", "Ha habido un error al realizar el ingreso");
			return "ingresar";
		}
		
	}
	
	/**
	 * Método que muestra la página de hacer retiradas.
	 */
	@GetMapping( "/retirar" )
	public String retirar() { return "retirar"; }
	
	/**
	 * Este método recupera la cuenta que ha iniciado sesión e intenta hacer una retirada de la cantidad
	 * indicada en la cuenta loggeada.
	 * Si es éxitosa la retirada muestra en la página un mensaje, si no, muestra otro mensaje de error.
	 * Si intentas sacar más dinero del que tienes, muestra un mensaje de error diferente.
	 */
	@PostMapping( "/retirada" )
	public String hacerRetirada( Model model, HttpSession sesion, @RequestParam( "cantidad" ) double cantidad ) {
		
		Cuenta cuenta = (Cuenta) sesion.getAttribute( "cuenta" );
		
		if( cantidad <= cuenta.getSaldo() ) {
			
			if( movimientoDao.retirar( cuenta, cantidad ) ) {
				model.addAttribute("mensajeRetirada", "Dinero retirado con éxito");
				model.addAttribute("totalDespuesRetirada", cuenta.getSaldo() );
				return "retirar";
			} else {
				model.addAttribute("mensajeErrorRetirada", "Ha habido un error al realizar la retirada");
				return "retirar";
			}
			
		} else {
			
			model.addAttribute("mensajeCreditoRetirada", "No puedes retirar esa cantidad, no te queda suficiente saldo.");
			return "retirar";
			
		}
		
	}
	
	/**
	 * Método que muestra la página de hacer transferencias.
	 */
	@GetMapping( "/transferencia" )
	public String transferencia() { return "transferencia"; }
	
	/**
	 * Método que recibe un número de cuenta y una cantidad.
	 * En primera instancia recupera la cuenta que ha iniciado sesión, seguidamente comprueba si la cuenta de destino existe,
	 * si existe, almacena la cuenta de destino en una variable y crea 2 movimiento, uno de ingreso en la cuenta de destino
	 * y uno de retirada en la cuenta de origen. Al mismo tiempo modifica los saldos en ambas cuentas.
	 * Si intentas transferir más dinero del que tienes, también dará error.
	 */
	@PostMapping( "/transferir" )
	public String transferir( HttpSession sesion, Model model, @RequestParam( "cantidad" ) double cantidad, @RequestParam( "idCuenta" ) int idCuenta ) {
		
		Cuenta cuentaOrigen = (Cuenta) sesion.getAttribute( "cuenta" );
		Cuenta cuentaDestino;
		
		if( cuentaDao.comprobarCuenta( idCuenta ) ) {

			cuentaDestino = cuentaDao.buscarUna( idCuenta );
			
			if( cuentaDestino.getSaldo() < cantidad ) {
				movimientoDao.ingresar( cuentaDestino, cantidad );
				movimientoDao.retirar( cuentaOrigen, cantidad );
				model.addAttribute("mensajeExitoTransferencia", "¡Éxito! transferencia realizada correctamente.");
			} else {
				model.addAttribute("mensajeErrorTransferencia", "¡Error! No tienes saldo suficiente.");
			}
			
		} else {
			model.addAttribute("mensajeErrorTransferencia", "¡Error! La cuenta de destino no existe.");
		}

		return "transferencia";
		
	}
	
}
