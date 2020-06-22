package main;
/*
 * Grupo 1
 * @author Paula Gibbs
 * @author Yael Arellano
 * @author Luis Riquelme
 * @author Kristian Lacomas
 * @date   18FEB2020
 * Desafio Cajero Automatico
*/

import java.util.Scanner;
import modelo.*;


public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Servicios.ingresarClientes();//se ingresa la lista de clientes a Servicios.Clientes
		Servicios.validarCliente(); //asigna el cliente validado a Servicios.esCliente
		Servicios.mensajeBienvenida(Servicios.getEsCliente().getNombre(), Servicios.getEsCliente().getFechaNacimiento());
		Servicios.desplegarMenu("Menu Principal");
		
		//mensaje de salida de cajero y termino del programa
		Servicios.mensajeSalida(Servicios.getEsCliente().getNombre());
		sc.close();
	}// FIN MAIN

}
