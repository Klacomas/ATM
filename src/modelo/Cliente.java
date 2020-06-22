package modelo;

import java.time.LocalDate;

public class Cliente {
	protected String rut;
	protected String nombre;
	protected int clave;
	protected LocalDate fechaNacimiento;
	protected CtaCte ctaCliente;
	protected TCredito tcCliente;
	protected Ejecutiva ejecCliente;
	
	public Cliente(String rut, String nombre, int clave, LocalDate fechaNacimiento, CtaCte ctaCliente,
			TCredito tcCliente, Ejecutiva ejecCliente) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.clave = clave;
		this.fechaNacimiento = fechaNacimiento;
		this.ctaCliente = ctaCliente;
		this.tcCliente = tcCliente;
		this.ejecCliente = ejecCliente;
	}
	
	public Cliente() {
		super();
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getClave() {
		return clave;
	}
	
	public void setClave(int clave) {
		this.clave = clave;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public CtaCte getCtaCliente() {
		return ctaCliente;
	}
	
	public void setCtaCliente(CtaCte ctaCliente) {
		this.ctaCliente = ctaCliente;
	}
	
	public TCredito getTcCliente() {
		return tcCliente;
	}
	
	public void setTcCliente(TCredito tcCliente) {
		this.tcCliente = tcCliente;
	}
	
	public Ejecutiva getEjecCliente() {
		return ejecCliente;
	}
	
	public void setEjecCliente(Ejecutiva ejecCliente) {
		this.ejecCliente = ejecCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", nombre=" + nombre + ", clave=" + clave + ", fechaNacimiento="
				+ fechaNacimiento + ", ctaCliente=" + ctaCliente + ", tcCliente=" + tcCliente + ", ejecCliente="
				+ ejecCliente + "]";
	}
	
}