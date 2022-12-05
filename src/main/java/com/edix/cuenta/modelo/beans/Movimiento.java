package com.edix.cuenta.modelo.beans;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table( name="movimientos" )
public class Movimiento implements Serializable {
	
	
	// Atributos.
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movimiento")
	private int idMovimiento;

	private double cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String operacion;

	//una Cuenta tienes muchos Movimientos.
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;
	
	
	// Constructores
	

	public Movimiento() {}
	
	public Movimiento(int idMovimiento, double cantidad, Date fecha, String operacion, Cuenta cuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}


	// Getters & Setters.
	

	public int getIdMovimiento() { return this.idMovimiento; }

	public void setIdMovimiento(int idMovimiento) { this.idMovimiento = idMovimiento; }

	public double getCantidad() { return this.cantidad;	}

	public void setCantidad(double cantidad) { this.cantidad = cantidad; }

	public Date getFecha() { return this.fecha;	}

	public void setFecha(Date fecha) { this.fecha = fecha; }

	public String getOperacion() { return this.operacion; }

	public void setOperacion(String operacion) { this.operacion = operacion; }

	public Cuenta getCuenta() { return this.cuenta; }

	public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

	
	// hashCode & equals.
	
	
	@Override
	public int hashCode() { return Objects.hash(idMovimiento); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Movimiento))
			return false;
		Movimiento other = (Movimiento) obj;
		return idMovimiento == other.idMovimiento;
	}

	
	// toString.
	
	
	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", operacion=" + operacion + ", cuenta=" + cuenta + "]";
	}
	

}