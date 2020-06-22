package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Servicios {
	// el array de clientes para utilizar y poder modificar

	protected static ArrayList<Cliente> Clientes;
	protected static Cliente esCliente;
	protected static Scanner sc = new Scanner(System.in);

	public Servicios() {
		super();
	}

	public Servicios(ArrayList<Cliente> clientes, Cliente esCliente) {
		super();
		this.Clientes = clientes;
		this.esCliente = esCliente;
	}

	public ArrayList<Cliente> getClientes() {
		return Clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		Clientes = clientes;
	}

	public static Cliente getEsCliente() {
		return esCliente;
	}

	public static void setEsCliente(Cliente esCliente) {
		Servicios.esCliente = esCliente;
	}

	// Aqui van los otros metodos

	// ingreso cliente manualmente
	public static void ingresarClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		Ejecutiva ejecutiva;
		CtaCte ctaCte;
		TCredito tCredito;
		try {
			// Misma ejecutiva para todos
			ejecutiva = new Ejecutiva("Marta Reyes", "56 22 345 5667", "Moneda 856, Santiago Centro");

			// ingreso de clientes manualmente
			ctaCte = new CtaCte(00, 234500, 15000);
			tCredito = new TCredito(01, 1265430, 234570, 1500000);
			cliente = new Cliente("91", "Paula", 1212, convertirAFecha("16-07-1969"), ctaCte, tCredito, ejecutiva);
			clientes.add(cliente);

			ctaCte = new CtaCte(00, 2000000, 15000);
			tCredito = new TCredito(01, 976544, 23456, 1000000);
			cliente = new Cliente("92", "Yael", 1114, convertirAFecha("10-03-1994"), ctaCte, tCredito, ejecutiva);
			clientes.add(cliente);

			ctaCte = new CtaCte(00, 2000000, 15000);
			tCredito = new TCredito(01, 976544, 23456, 1000000);
			cliente = new Cliente("93", "Luis", 1241, convertirAFecha("22-01-1990"), ctaCte, tCredito, ejecutiva);
			clientes.add(cliente);

			ctaCte = new CtaCte(00, 2000000, 15000);
			tCredito = new TCredito(01, 976544, 23456, 1000000);
			cliente = new Cliente("94", "Kristian", 1323, convertirAFecha("20-10-1974"), ctaCte, tCredito, ejecutiva);
			clientes.add(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Clientes = clientes; // cargando los Clientes directamente en el ArrayList de Servicios
//		return clientes; // retorna clientes ingresados
	}// FIN Ingreso Clientes

	public static void validarCliente() {
		// Scanner sc = new Scanner(System.in);
//		ingresarClientes();// se ingresa los clientes a Clientes
		String rutCliente;
//		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		boolean clienteOkay = false;
		boolean claveOkay = false;
		Cliente cliente = new Cliente();
		try {
			do {
				System.out.println("\n\nATM Banco Banco SafeBank");
				System.out.println("\nIngrese su R.U.T. sin punto ni guion ");
				rutCliente = sc.nextLine(); // ??? aqui se cae al salir del menu
				for (Cliente clienteTmp : Clientes) {
					if (clienteTmp.getRut().equals(rutCliente)) {
						do {
							claveOkay = verificarClave(clienteTmp.getClave()); // Validacion clave cliente
							if (claveOkay == true) {
								clienteOkay = true;
								cliente = clienteTmp;
								break;
							} else {
								clienteOkay = false;
							}
						} while (claveOkay != true);
					} // FIN IF comparacion rut
				}
			} while (clienteOkay != true);
		} catch (Exception e) {
			e.printStackTrace();
		}
//			sc.close();
		esCliente = cliente;// asigna el cliente encontrado a esCliente
//		return cliente;
	}

	public static boolean verificarClave(int claveCliente) {
//		Scanner sc = new Scanner(System.in);
		boolean claveOkay = false;
		String clave;
		int esNro;
		do {
			System.out.println("ingrese Clave:");
			clave = sc.nextLine();
			esNro = soloNros(clave);
			if (esNro == claveCliente) {
				claveOkay = true;
			} else {
				System.out.println("Clave ingresada invalida");
			}
		} while (claveOkay != true);
		return claveOkay;
	}

	public static void mensajeBienvenida(String nombreCliente, LocalDate fechaNacimiento) {
		int edad = calcularEdad(fechaNacimiento);
		System.out.println("\nBienvenido " + nombreCliente + ",  Edad (" + edad + ")");
	}

	public static void mensajeSalida(String nombreCliente) {
		System.out.println("\nCerrando sesión ...");
		System.out.println("Hasta luego " + nombreCliente);
		System.out.println("- - - - - - - - - - - - - - -\n");
	}

	// calcula la edad del cliente para mostralo en el mensaje de bienvenida
	public static int calcularEdad(LocalDate fechaNacimiento) {
		// define el formato para la fecha
//			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate hoy = LocalDate.now(); // fecha actual
		Period periodo = Period.between(fechaNacimiento, hoy);
		return periodo.getYears();
	}

	// convierte String en nros (eliminando las letras digitadas)
	public static int soloNros(String nro) {
		// Reemplaza todos los caracteres que no son numero por espacio
		String numero = nro.replaceAll("[^0-9]", "");
		// Si queda solo espacio vacia
		if (numero.equals("")) {
			numero = "0";
		}
		// devuelve el String de numeros convertido en entero
		return Integer.parseInt(numero);
	}

	// Combierte un String fecha a LocalDate
	private static LocalDate convertirAFecha(String strFecha) {
		LocalDate date = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		date = LocalDate.parse(strFecha, formatter);
		return date;
	}

	// Para retiro dinero de la cta cte.
	public static void ctaCteRetirarDinero() {
		double paraRetirar, saldo, saldoActual;
		for (Cliente clienteActual : Clientes) {
			if (clienteActual.getRut().equals(esCliente.getRut())) {
				System.out.println("Cuánto desea retirar ? (0 para cancelar)");
				paraRetirar = sc.nextDouble();
				if (paraRetirar > 0) {
					saldo = esCliente.getCtaCliente().getSaldo();
					saldoActual = saldo - paraRetirar;
					// se actualiza el saldo de la cuenta al pagar la deuda
					esCliente.getCtaCliente().setSaldo(saldoActual);
					System.out.println("Dinero retirado, volviendo al menú de cuenta corriente.");
					System.out.println("- - - - - - - - - - - - - - -\n");
				} else {
					System.out.println(" No se realizo retiro de dinero.\n Volviendo al menú de cuenta corriente.");
					System.out.println("- - - - - - - - - - - - - - -\n");
				}
				break;
			}
		}
	}

	// Paga la deuda de la cuenta corriente
	public static void ctaCtePagarDeuda() {
		for (Cliente clienteActual : Clientes) {
			if (clienteActual.getRut().equals(esCliente.getRut())) {
				double deuda = esCliente.getCtaCliente().getDeuda();
				double saldo = esCliente.getCtaCliente().getSaldo();
				double saldoActual = saldo - deuda;
				// se actualiza el saldo de la cuenta al pagar la deuda
				esCliente.getCtaCliente().setSaldo(saldoActual);
				// La desuda queda en cero
				esCliente.getCtaCliente().setDeuda(0);
				break;
			}
		}
		System.out.println("Su deuda ha sido pagada, volviendo al menú de cuenta corriente.");
		System.out.println("- - - - - - - - - - - - - - -\n");
	}

	// Se paga deuda abonando un monto
	public static void tCreditoPagar(String rutCliente, double abono) {
		String nombreCliente = " ";
		double deudaActual = 0;
		for (Cliente clienteActual : Clientes) {
			if (clienteActual.getRut().equals(esCliente.getRut())) {
				// Calculo de los valos actualizando los montos
				deudaActual = esCliente.getTcCliente().getDeuda() - abono;
				double saldoActual = esCliente.getTcCliente().getSaldoMax() - deudaActual;
				System.out.println("Se ha reducido tu deuda en $" + abono);
				System.out.println("- - - - - - - - - - - - - - -\n");
				// Se modifica los valores en la lista de Clientes directamente
				esCliente.getTcCliente().setDeuda(deudaActual);
				esCliente.getTcCliente().setSaldo(saldoActual);
				break;
			}
		}
	}

	// sobrecarga metodo, se paga toda la deuda en la tarjeta de credito
	public static void tCreditoPagar(String rutCliente) {
		String nombreCliente = " ";
		double deudaActual = 0;
		for (Cliente clienteActual : Clientes) {
			if (clienteActual.getRut().equals(esCliente.getRut())) {
				// Calculo de los valos actualizando los montos
				double saldoActual = esCliente.getTcCliente().getSaldoMax();
				// Se modifica los valores en la lista de Clientes directamente
				esCliente.getTcCliente().setDeuda(0);
				esCliente.getTcCliente().setSaldo(saldoActual);
				// mensaje de que se realizo
				System.out.println(" Deuda completa pagada");
				System.out.println("-----------------------------------\n");
				System.out.println(esCliente.getTcCliente().toString());
				System.out.println("... Volviendo al menu principal\n");
				break;
			}
		}

	}

	// Para desplegar el menu aqui comienza todo

	public static void desplegarMenu(String strMenu) {
		Menu menu = new Menu(strMenu, 0, Servicios.obtenerOpciones(strMenu));
		menu.desplegar();
		int intOpcion = menu.leerOpcion();
		if (intOpcion!=4) {//si en el menu principal  la opcion es 4 (Salir)
			Servicios.ejecutarAccion(intOpcion, strMenu);
			desplegarMenu("Menu Principal");
		}	
	}

	public static ArrayList<Opcion> obtenerOpciones(String nombreMenu) {
		ArrayList<Opcion> lstOpciones = new ArrayList<Opcion>();
		Opcion opcion;
		if (nombreMenu.equals("Menu Principal")) {
			opcion = new Opcion("Menu Cuenta Corriente", 1, 1);
			lstOpciones.add(opcion);
			opcion = new Opcion("Menu Tarjeta de Crédito", 2, 2);
			lstOpciones.add(opcion);
			opcion = new Opcion("Ver datos de mi ejecutivo", 3, 3);
			lstOpciones.add(opcion);
			opcion = new Opcion("Salir", 4, 4);
			lstOpciones.add(opcion);

		} else if (nombreMenu.equals("Menu Cuenta Corriente")) {
			opcion = new Opcion("Volver al menú", 1, 1);
			lstOpciones.add(opcion);
			opcion = new Opcion("Retirar Dinero", 2, 2);
			lstOpciones.add(opcion);
			opcion = new Opcion("Pagar mi deuda", 3, 3);
			lstOpciones.add(opcion);
		} else if (nombreMenu.equals("Menu Tarjeta de Crédito")) {
			opcion = new Opcion("Volver al menú", 1, 1);
			lstOpciones.add(opcion);
			opcion = new Opcion("Pagar mi deuda", 2, 2);
			lstOpciones.add(opcion);
		} else if (nombreMenu.equals("Pagar mi deuda")) {
			opcion = new Opcion("Deuda completa", 1, 1);
			lstOpciones.add(opcion);
			opcion = new Opcion("Otro monto", 2, 2);
			lstOpciones.add(opcion);
		}

		return lstOpciones;
	}

	public static String obtenerTitulo(String nombreMenu) {
		String strTitulo = new String();
		if(nombreMenu.equals("Menu Principal")) {
			strTitulo = "Menu Principal";
		} else if (nombreMenu.equals("Menu Cuenta Corriente")) {
			strTitulo = "Menu Cuenta Corriente";
		} else if (nombreMenu.equals("Menu Tarjeta de Crédito")) {
			strTitulo = "Menu Tarjeta de Crédito";
		} else if (nombreMenu.equals("Pagar mi deuda")) {
			strTitulo = "Pagar mi deuda";
		}
		strTitulo = "---" + strTitulo + "---";
		return strTitulo;
	}

	public static void ejecutarAccion(int intOpcion, String strMenu) {
		System.out.println(strMenu + " opcion " + intOpcion);
		if (strMenu.equals("Menu Principal")) {
			switch (intOpcion) {
			case 1:
				System.out.println(esCliente.getCtaCliente().toString());
				desplegarMenu("Menu Cuenta Corriente");
				break;
			case 2:
				System.out.println(esCliente.getTcCliente().toString());
				desplegarMenu("Menu Tarjeta de Crédito");
				break;
			case 3:
				System.out.println("\n- - - - - - - -\n" + esCliente.getEjecCliente().toString());
				break;
			case 4:
				break;
			}

		} else if (strMenu.equals("Menu Cuenta Corriente")) {
			System.out.println(esCliente.getCtaCliente().toString());
			switch (intOpcion) {
			case 1:
				desplegarMenu("Menu Principal");
				break;

			case 2:
				ctaCteRetirarDinero();
				System.out.println(esCliente.getCtaCliente().toString());
				desplegarMenu("Menu Cuenta Corriente");
				break;

			case 3:
				ctaCtePagarDeuda();
				System.out.println(esCliente.getCtaCliente().toString());
				desplegarMenu("Menu Cuenta Corriente");
				break;
			}
		} else if (strMenu.equals("Menu Tarjeta de Crédito")) {
			System.out.println(esCliente.getTcCliente().toString());
			switch (intOpcion) {
			case 1:
				desplegarMenu("Menu Principal");
				break;

			case 2:
				desplegarMenu("Pagar mi deuda");
				break;
			}

		} else if (strMenu.equals("Pagar mi deuda")) {
			switch (intOpcion) {
			case 1:
				tCreditoPagar(esCliente.getRut());
				break;

			case 2:
				System.out.println(
						"IngreIngresa el monto que deseas pagar (máximo $" + esCliente.getTcCliente().getDeuda() + ")");
				double abonarTC = sc.nextDouble();
				tCreditoPagar(esCliente.getRut(), abonarTC);
				desplegarMenu("Menu Tarjeta de Crédito");
				break;

			}
		}
	}

}
