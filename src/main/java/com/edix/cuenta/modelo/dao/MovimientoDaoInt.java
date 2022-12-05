package com.edix.cuenta.modelo.dao;
import java.util.List;

import com.edix.cuenta.modelo.beans.Cuenta;
import com.edix.cuenta.modelo.beans.Movimiento;


public interface MovimientoDaoInt {

	List<Movimiento> buscarTodos();
	boolean ingresar( Cuenta cuenta, double cantidad );
	boolean retirar( Cuenta cuenta, double cantidad );
	List<Movimiento> buscarMovimientosPorCuenta( int idCuenta );
	
}
