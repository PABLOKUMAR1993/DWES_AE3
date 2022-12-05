package com.edix.cuenta.modelo.dao;
import java.util.List;
import com.edix.cuenta.modelo.beans.Cuenta;


public interface CuentaDaoInt {

	List<Cuenta> buscarTodas();
	Cuenta buscarUna( int idCuenta );
	boolean comprobarCuenta( int idCuenta );
	
}
