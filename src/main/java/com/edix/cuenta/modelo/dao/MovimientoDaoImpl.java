package com.edix.cuenta.modelo.dao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edix.cuenta.modelo.beans.Cuenta;
import com.edix.cuenta.modelo.beans.Movimiento;
import com.edix.cuenta.repository.CuentaRepoInt;
import com.edix.cuenta.repository.MovimientoRepoInt;


@Repository
public class MovimientoDaoImpl implements MovimientoDaoInt {

	
	// Atributos.
	
	
	@Autowired
	private MovimientoRepoInt movimientoRepo;
	
	@Autowired
	private CuentaRepoInt cuentaRepo;
	
	
	// Métodos Implementados.
	
	
	/**
	 * Método que devuelve una lista de todos los movimientos.
	 */
	@Override
	public List<Movimiento> buscarTodos() {
		return null;
	}

	/**
	 * Realiza ingresos y modifica el saldo total en la base de datos.
	 * Recibe una cuenta y una cantidad, por un lado crea un movimiento en la tabla "movimientos",
	 * con la cantidad recibida. Seguidamente modifica el objeto cuenta sumandole la cantidad recibida
	 * y lo modifica en la tabla "cuentas".
	 * 
	 * Devuelve true, si ha realizado el movimiento y la modificación del saldo.
	 * Devuelve false, si ha encontrado algún error.
	 */
	@Override
	public boolean ingresar( Cuenta cuenta, double cantidad ) {
		
		Movimiento movimiento = new Movimiento( 0, cantidad, new Date(), "ingreso", cuenta );
		cuenta.setSaldo( cuenta.getSaldo() + cantidad );
		
		try {
			movimientoRepo.save( movimiento );
			cuentaRepo.save( cuenta );
			return true;
		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Realiza retiradas y modifica el saldo total en la base de datos.
	 * Recibe una cuenta y una cantidad, por un lado crea un movimiento en la tabla "movimientos",
	 * con la cantidad recibida. Seguidamente modifica el objeto cuenta restandole la cantidad recibida
	 * y lo modifica en la tabla "cuentas".
	 * Durante este proceso se añade una condicion, si la cantidad a restar es inferior que el saldo
	 * restante, no se hace la operación, no puede tener saldo negativo.
	 * 
	 * Devuelve true, si ha realizado el movimiento y la modificación del saldo.
	 * Devuelve false, si ha encontrado algún error o si el saldo resultante es negativo.
	 */
	@Override
	public boolean retirar( Cuenta cuenta, double cantidad ) {
		
		Movimiento movimiento = new Movimiento( 0, cantidad, new Date(), "retirada", cuenta );
		cuenta.setSaldo( cuenta.getSaldo() - cantidad );
		
		try {
			movimientoRepo.save( movimiento );
			cuentaRepo.save( cuenta );
			return true;
		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Crea una select personalizada, la cual devuelve todos los movimientos que coinciden con el idCuenta pasado.
	 */
	@Override
	public List<Movimiento> buscarMovimientosPorCuenta( int idCuenta ) { return movimientoRepo.buscarMovimientosPorCuenta( idCuenta ); }
	

}
