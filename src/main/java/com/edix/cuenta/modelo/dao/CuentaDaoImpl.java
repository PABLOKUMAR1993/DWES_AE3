package com.edix.cuenta.modelo.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edix.cuenta.modelo.beans.Cuenta;
import com.edix.cuenta.repository.CuentaRepoInt;


@Repository
public class CuentaDaoImpl implements CuentaDaoInt {

	
	// Atributos.
	
	
	@Autowired
	private CuentaRepoInt cuentaRepo;
	
	
	// Métodos Implementados.
	
	
	/**
	 * Devuelve una lista de todas las cuentas.
	 */
	@Override
	public List<Cuenta> buscarTodas() { return cuentaRepo.findAll(); }

	/**
	 * Devuelve una cuenta pasada por id o null si no existe.
	 */
	@Override
	public Cuenta buscarUna( int idCuenta ) { return cuentaRepo.findById( idCuenta ).orElse( null ); }

	
	/**
	 * Este método recibe un ID de número de cuenta y comprueba si existe.
	 * Devuelve ture si existe el id de cuenta.
	 * Devuelve false si no existe el id de cuenta.
	 */
	@Override
	public boolean comprobarCuenta( int idCuenta ) {
		
		Optional<Cuenta> op = cuentaRepo.findById( idCuenta );
		
		if( op.isPresent() ) return true;
		else return false;
		
	}
	

}
