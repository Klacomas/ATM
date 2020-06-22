package modelo;

public class Ejecutiva {
	protected String nombre;
	protected String telefono;
	protected String direccion;
	
	public Ejecutiva(String nombre, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public Ejecutiva() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Datos de tu Ejecutiva \n Nombre: " + nombre + "\n Telefono: " + telefono + "\n Direccion: " + direccion + "\n";
	}
	
	

}
