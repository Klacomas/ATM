package modelo;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
	
	protected String titulo ;
	protected int seleccion ;
	protected ArrayList<Opcion> opciones;
			
	public Menu(String titulo, int seleccion, ArrayList<Opcion> opciones) {
		super();
		this.titulo = titulo;
		this.seleccion = seleccion;
		this.opciones = opciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}

	public ArrayList<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<Opcion> opciones) {
		this.opciones = opciones;
	}

	public void desplegar()		{
		System.out.println("---" + this.titulo+"---");
		for (Opcion opcion:this.opciones) {
			
			System.out.println(opcion.getOpcion() + " - " + opcion.getTitulo());
		}
		System.out.println("Ingrese su opción==>");
	}

	public int leerOpcion() {
		Scanner sc = new Scanner(System.in);
		
		return sc.nextInt();
	}


	
	

}

