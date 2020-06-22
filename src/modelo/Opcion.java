package modelo;

public class Opcion {
	protected String titulo ;
	protected int opcion ; 
	protected int accion ;

	
	public Opcion(String titulo, int opcion, int accion) {
		super();
		this.titulo = titulo;
		this.opcion = opcion;
		this.accion = accion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getOpcion() {
		return opcion;
	}
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	public int getAccion() {
		return accion;
	}
	public void setAccion(int accion) {
		this.accion = accion;
	}
	
}
