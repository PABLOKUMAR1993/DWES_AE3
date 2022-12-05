package com.edix.cuenta.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.edix.cuenta.modelo.beans.Movimiento;


public interface MovimientoRepoInt extends JpaRepository<Movimiento, Integer>{
	
	@Query( "select m from Movimiento m where m.cuenta.idCuenta = ?1" )
	public List<Movimiento> buscarMovimientosPorCuenta( int idCuenta );
	
}
